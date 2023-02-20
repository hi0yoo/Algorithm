package baekjoon.kotlin.boj

fun main() {
    val n = readln().toInt()
    val arr = Array(n + 1) { LongArray(10) { 1 } }
    arr[1][0] = 0
    for (i in 2..n) {
        for (j in 0..9) {
            when (j) {
                0 -> arr[i][j] = arr[i - 1][j + 1]
                9 -> arr[i][j] = arr[i - 1][j - 1]
                else -> arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1_000_000_000
            }
        }
    }
    var sum: Long = 0
    for (i in 0..9) sum = (sum + arr[n][i]) % 1_000_000_000
    println(sum)
}
