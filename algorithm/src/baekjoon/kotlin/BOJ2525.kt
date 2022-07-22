package baekjoon

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readLine())
    var h = Integer.parseInt(st.nextToken())
    var m = Integer.parseInt(st.nextToken())

    val time = readLine()!!.toInt()

    m += time

    if (m >= 60) {
        h += m / 60
        m %= 60
    }

    if (h >= 24) {
        h -= 24
    }

    println("$h $m")
}