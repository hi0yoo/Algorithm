package baekjoon.kotlin.boj

import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()!!.toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }
    val result = IntArray(n + 1)
    var max = 1
    result[max] = arr[0]
    for (i in 1 until n) {
        var k = max
        while (arr[i] <= result[k]) k--
        if (k <= 0) result[1] = arr[i]
        else {
            result[k + 1] = arr[i]
            if (k == max) max++
        }
    }
    println(max)
}
