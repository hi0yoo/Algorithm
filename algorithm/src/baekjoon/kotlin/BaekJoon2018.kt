package baekjoon.kotlin

fun main() {
    var result = 1
    val n = readLine()!!.toInt()
    val a = IntArray(n + 1)
    var l = 1
    for (k in 1..n) {
        a[k] = a[k - 1] + k
        while (l < k) {
            val num = a[k] - a[l - 1]
            if (num == n) {
                result++
                break
            } else if (num < n) {
                break
            } else {
                l++
            }
        }
    }
    println(result)
}