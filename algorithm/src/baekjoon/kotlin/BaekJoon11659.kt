package baekjoon.kotlin

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    val a = IntArray(n + 1) {0}
    for (i in 1 .. n) {
        a[i] = a[i - 1] + st.nextToken().toInt()
    }

    val sb = StringBuffer()
    for (i in 0 until m) {
        st = StringTokenizer(readLine())
        sb.append("${0-a[st.nextToken().toInt()-1]+a[st.nextToken().toInt()]}\n")
    }
    println(sb)
}