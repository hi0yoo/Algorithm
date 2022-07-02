package baekjoon.kotlin

import java.util.StringTokenizer

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val st = StringTokenizer(readLine())
    val a = IntArray(n)
    for (k in 0 until n) {
        a[k] = st.nextToken().toInt()
    }
    a.sort()

    var result = 0
    var i = 0
    var j = n - 1
    while (i < j) {
        val sum = a[i] + a[j]
        if (sum < m) {
            i++
        } else if (sum > m) {
            j--
        } else {
            result++
            i++
            j--
        }
    }
    println(result)
}