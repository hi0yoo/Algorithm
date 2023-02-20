package baekjoon.kotlin.boj

fun main() {
    val n = readln().toInt()
    val arr = Array(n + 1) { LongArray(2) }
    arr[1][1] = 1
    if (n >= 2) arr[2][0] = 1
    for (i in 3..n) {
        arr[i][0] = arr[i - 1][0] + arr[i - 1][1]
        arr[i][1] = arr[i - 1][0]
    }
    println(arr[n][0] + arr[n][1])
}
