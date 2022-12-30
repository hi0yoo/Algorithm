package programmers.solution

import kotlin.math.pow

class MagicElevator {
    /*
    엘리베이터는 절대값이 10^c(c >= 0)인 형태의 정수 버튼이 있다.
    버튼을 누르면 버튼에 적힌 수와 현재 층 수를 더한 층으로 이동
    버튼과 현재 층 수를 더한 결과가 0보다 작으면 움직이지 않음
    0이 가장 아랫층

    엘리베이터를 움직이려면 버튼 한 번당 돌 하나 소모
    16층에서 0층 가려면 -1 버튼 6번, -10 버튼 1번 <- 7개 소모 or 1 버튼 4번, -10 버튼 2번 <- 6개 소모

    현재 층에서 0층으로 가는데 필요한 돌의 최소 개수

    storey : 현재 층 위치 (1 <= storey <= 100,000,000)

    16 -> 6
    2554 -> 16

    ->
    3761 -> -1 * 1 = 1
    3760 -> +10 * 4 = 4 => 5
    3800 -> +100 * 2 = 2 => 7
    4000 -> -1000 * 4 = 4 => 11

    35 -> 빼야함, -5, -30 -> 8
    45 -> 빼야함, -5 -40 -> 9
    55 -> 더하는 경우 +5, -60 -> 11 / 빼는 경우 -5, -50 -> 10 / 혼합 +5 +40 -100 -> 10
    65 -> 더하는 경우 +5, -70 -> 12 / 빼는 경우 -5, -60 -> 11 / 혼합 +5 +30 -100 -> 8

    12345 -> 15 ?


    (1자리부터 시작) 현재 확인중인 자릿 수가
    5 보다 작으면 뺀다
    5 이면
        다음 자릿수를 확인한다.
        다음 자릿수가 4 이하(없는 것 포함)이면 뺀다.
        다음 자릿수가 5 이상이면 더한다.
    5 보다 크면 더한다

    121 / 10 => 12, 12 / 10 => 1
    100 / 10 => 10, 10 / 10 => 1
     */

    fun solution(storey: Int): Int {
        var answer = 0

        var remainStorey = storey
        // 자릿수 계산
        var countNumbers = 1
        var n = 10
        while (storey / n > 0) {
            n *= 10
            countNumbers++
        }

        // 자릿수 만큼 진행
        for (i in 1 .. countNumbers) {
            val number = getNumber(i, remainStorey)
            if (number > 5) {
                remainStorey += getMultipleDigitNumber(i, 10 - number)
                answer += (10 - number)
            } else if (number < 5) {
                remainStorey -= getMultipleDigitNumber(i, number)
                answer += number
            } else {
                // 다음 자릿수가 없으면 뺀다.
                if (i + 1 > countNumbers) {
                    remainStorey -= getMultipleDigitNumber(i, number)
                    answer += number
                } else {
                    // 다음 자릿수
                    val nextNumber = getNumber(i + 1, remainStorey)
                    if (nextNumber <= 4) {
                        remainStorey -= getMultipleDigitNumber(i, number)
                        answer += number
                    } else {
                        remainStorey += getMultipleDigitNumber(i, 10 - number)
                        answer += (10 - number)
                    }
                }
            }
        }

        if (remainStorey != 0 && remainStorey % 10 == 0) answer++;

        return answer
    }

    private fun getMultipleDigitNumber(i: Int, k: Int) = ((10).toDouble().pow(i - 1) * k).toInt()

    // k번째 자릿수 값 꺼냄
    private fun getNumber(k: Int, storey: Int): Int = ((storey / (10).toDouble().pow(k - 1)) % 10).toInt()
}