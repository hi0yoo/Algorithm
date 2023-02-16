package baekjoon.kotlin.boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val n = readln()
    for (i in n.indices) {
        if (i == 0) write(binaryNumber(n[i]))
        else write(binaryNumber(n[i]).padStart(3, '0'))
    }
    flush()
    close()
}

private fun binaryNumber(c: Char): String = when (c.code - 48) {
    1 -> "1"
    2 -> "10"
    3 -> "11"
    4 -> "100"
    5 -> "101"
    6 -> "110"
    7 -> "111"
    else -> "0"
}
