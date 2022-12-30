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
        // 자릿수
        val digitCount = remainStorey.toString().length

        // 자릿수 만큼 진행
        for (i in 1 .. digitCount) {
            // 10^(i-1)의 자릿수 값
            val digitNum = getDigitNumberFrom(digitAt = i, num = remainStorey)
            // 자릿수의 값이 5보다 크면 +10^(i-1) 버튼을 통해 올라간다.
            if (digitNum > 5) {
                remainStorey += makeDigitNumber(digit = i, num = 10 - digitNum)
                answer += (10 - digitNum)
            }
            // 자릿수의 값이 5보다 작으면 -10^(i-1) 버튼을 통해 내려간다.
            else if (digitNum < 5) {
                remainStorey -= makeDigitNumber(digit = i, num = digitNum)
                answer += digitNum
            }
            // 자릿수의 값이 5이면 다음 자릿수를 확인한다.
            else {
                // 다음 자릿수가 없으면 -10^(i-1) 버튼을 통해 내려간다.
                if (i + 1 > digitCount) {
                    remainStorey -= makeDigitNumber(digit = i, num = digitNum)
                    answer += digitNum
                } else {
                    // 다음 자릿수
                    val nextDigitNumber = getDigitNumberFrom(num = remainStorey, digitAt = i + 1)
                    // 다음 자릿수가 4 이하이면 -10^(i-1) 버튼을 통해 내려간다.
                    if (nextDigitNumber <= 4) {
                        remainStorey -= makeDigitNumber(digit = i, num = digitNum)
                        answer += digitNum
                    }
                    // 다음 자릿수가 5 이상이면 +10^(i-1) 버튼을 통해 내려간다.
                    else {
                        remainStorey += makeDigitNumber(digit = i, num = 10 - digitNum)
                        answer += (10 - digitNum)
                    }
                }
            }
        }

        // 기존 storey 의 가장 큰 자릿수에서 자릿수가 하나 더 생겼을 경우
        // ex) 9 -> 10이 된 경우, -10 버튼을 눌러줘야 한다.
        if (remainStorey != 0 && remainStorey % 10 == 0) answer++;

        return answer
    }

    // num * 10^(digit-1) 값 생성
    private fun makeDigitNumber(digit: Int, num: Int) = ((10).toDouble().pow(digit - 1) * num).toInt()

    // num 에서 digitAt 번째 자릿수 값 꺼냄
    private fun getDigitNumberFrom(num: Int, digitAt: Int): Int = ((num / (10).toDouble().pow(digitAt - 1)) % 10).toInt()
}