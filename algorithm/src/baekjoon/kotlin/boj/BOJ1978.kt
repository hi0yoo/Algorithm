package baekjoon.kotlin.boj

fun main() {
    val arr = BooleanArray(1001) { true }
    arr[0] = false
    arr[1] = false
    for (i in 2..1000) {
        if (arr[i]) {
            var num = i * 2
            while (num <= 1000) {
                arr[num] = false
                num += i
            }
        }
    }

    var answer = 0
    val n = readln().toInt()
    val s = readln().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        if (arr[s[i]]) answer++
    }
    println(answer)
}
