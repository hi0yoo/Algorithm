package baekjoon.kotlin.boj

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val s = br.readLine()
    val slen = s.length
    val sarr = Array(slen) { "" }
    for (i in 0 until slen) sarr[i] = s.substring(i, slen)
    sarr.sort()
    for (answer in sarr) bw.write("$answer\n")
    br.close()
    bw.flush()
    bw.close()
}
