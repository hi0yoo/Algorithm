package baekjoon.kotlin

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    var result:Long = 0
    val a = LongArray(n + 1) { 0 }
    val b = LongArray(m) { 0 }
    st = StringTokenizer(readLine())
    for (i in 1 .. n) {
        var num = st.nextToken().toLong()
        a[i] = (a[i-1] + num) % m
        if (a[i] == 0L) {
            result++
        }
        b[a[i].toInt()]++
    }
    for (i in 0 until m) {
        if (b[i] > 0) {
            result += (b[i] * (b[i] - 1)) / 2
        }
    }

    println(result)
}