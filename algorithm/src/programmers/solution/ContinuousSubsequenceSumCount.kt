package programmers.solution

/*
https://school.programmers.co.kr/learn/courses/30/lessons/131701

자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 몇가지?
7 9 1 1 4
처음과 끝이 연결됨
길이가 1 : sum = 1, 4, 7, 9
길이가 2 : sum = 2, 5, 10, 11, 16
길이가 3 : sum = 6, 11, 12, 17, 20
길이가 4 : sum = 13, 15, 18, 21
길이가 5 : sum = 22
-> 중복을 제거하면 총 18가지

3 <= elements.len <= 1,000
1 <= elements[k] <= 1,000

부분수열 길이가 1일 때, 숫자 종류만큼
부분수열 길이가 k일 때,
부분수열 길이가 len일 때, 1가지

길이가 n이면 n^2의 시간복잡도
 */
class ContinuousSubsequenceSumCount {
    fun solution(elements: IntArray): Int {
        var answer = 0

        val size = elements.size
        val arr = IntArray(size = size + 1)
        for ((index, num) in elements.withIndex()) arr[index + 1] = arr[index] + num

        // 등장 가능한 수의 종류
        val checkNumber = BooleanArray(size = arr[size] + 1)
        // 부분수열 길이가 1부터 size-1 일 때 부분수열 합을 구하여 체크
        for (i in 1 until size) {
            for (t in 1..size) {
                if (t - i < 0) {
                    checkNumber[arr[size] - arr[size + (t - i)] + arr[t]] = true
                } else {
                    checkNumber[arr[t] - arr[t - i]] = true
                }
            }
        }

        // 각기 다른 수의 개수 체크
        for (bool in checkNumber) if (bool) answer++

        return answer + 1
    }
}