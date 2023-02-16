package baekjoon.kotlin.boj

import java.io.*
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()!!.split(" ").map { it.toInt() }
    if (input[0] == 1) {
        println(abs(readLine()!!.toInt() - input[1]))
    }
    else {
        val a = readLine()!!.split(" ").map { it.toInt() }
        val arr = IntArray(input[0])
        for (i in 0 until input[0]) arr[i] = abs(input[1] - a[i])
        var gcd = arr[0]
        for (i in 1 until input[0]) gcd = gcd(arr[i], gcd)
        println(gcd)
    }
}

private fun gcd(a: Int, b: Int): Int {
    val max = if (a > b) a else b
    val min = if (max == a) b else a
    if (max % min == 0) return min
    return gcd(min, max % min)
}
