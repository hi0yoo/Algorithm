package baekjoon.kotlin.boj

import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        val arrSize = input[0] * (input[0] - 1) / 2
        var sum = 0L
        var ap = 1
        var bp = 2
        var count = 0
        while (++count <= arrSize) {
            sum += gcd(input[ap], input[bp]).toLong()
            if (bp >= input[0]) bp = (++ap + 1) else bp++
        }
        println(sum)
    }
}

private fun gcd(a: Int, b: Int): Int {
    if (a % b == 0) return b
    return gcd(b, a % b)
}
