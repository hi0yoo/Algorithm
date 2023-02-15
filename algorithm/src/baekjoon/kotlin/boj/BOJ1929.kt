package baekjoon.kotlin.boj

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = BooleanArray(1_000_001) { true }
    arr[1] = false
    for (i in 2..1_000_000) {
        if (arr[i]) {
            var num = i * 2
            while (num <= 1_000_000) {
                arr[num] = false
                num += i
            }
        }
    }

    val nums = readln().split(" ").map { it.toInt() }
    for (i in nums[0]..nums[1]) {
        if (arr[i]) {
            bw.write(i.toString())
            bw.newLine()
        }
    }
    bw.flush()
    bw.close()
}
