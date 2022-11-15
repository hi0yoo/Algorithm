package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val a = Array(n+1) { IntArray(n+1) { 0 } }
    for (i in 1 .. n) {
        st = StringTokenizer(readLine())
        for (j in 1 .. n) {
            a[i][j] = st.nextToken().toInt() + a[i-1][j] + a[i][j-1] - a[i-1][j-1]
        }
    }

    val sb = StringBuffer()
    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        var x1 = st.nextToken().toInt()
        var y1 = st.nextToken().toInt()
        var x2 = st.nextToken().toInt()
        var y2 = st.nextToken().toInt()
        sb.append("${ a[x2][y2] - a[x2][y1-1] - a[x1-1][y2] + a[x1 - 1][y1 - 1] }\n")
    }

    println(sb)
}