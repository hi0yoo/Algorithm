package baekjoon.kotlin.boj

fun main() {
    var answer = 0

    var n = readln().toInt()
    while (n / 5 > 0) {
        answer += n / 5
        n /= 5
    }

    println(answer)
}
