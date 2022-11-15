package baekjoon.kotlin.boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.System.`in`
import java.lang.System.out

fun main() {
    val br = BufferedReader(InputStreamReader(`in`))
    val bw = BufferedWriter(OutputStreamWriter(out))
    val n = br.readLine()!!.toInt()
    val s = br.readLine()!!.toString()

    var sum: Int = 0
    for (i in 0 until n) {
        sum += s[i].code - 48
    }

    bw.write("$sum")
    bw.flush()
}