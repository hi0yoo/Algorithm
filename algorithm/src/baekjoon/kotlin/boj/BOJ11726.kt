package baekjoon.kotlin.boj

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n + 1)
    arr[1] = 1
    if (n >= 2) arr[2] = 2
    if (n >= 3) arr[3] = 3
    for (i in 4..n) arr[i] = arr[i - 1] + arr[i - 2]
    println(arr[n])
}
