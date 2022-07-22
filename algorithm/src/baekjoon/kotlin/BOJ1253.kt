package baekjoon.kotlin

import java.util.StringTokenizer

fun main() {
    val n = readLine()!!.toInt()
    val a = IntArray(n)
    val st = StringTokenizer(readLine())

    for (i in 0 until n) {
        a[i] = st.nextToken().toInt()
    }
    a.sort()

    var result = 0
    for (i in 0 until n) {
        var k = 0
        var l = n-1
        while (k < l) {
            if (k == i) {
                k++
                continue
            } else if (l == i) {
                l--
                continue
            }
            val sum = a[k] + a[l]
            if (sum == a[i]) {
                result++
                break
            } else if (sum > a[i]) {
                l--
            } else {
                k++
            }
        }
    }
    println(result)
}