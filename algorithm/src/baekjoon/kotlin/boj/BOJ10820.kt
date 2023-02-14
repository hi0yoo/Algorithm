package baekjoon.kotlin.boj

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        try {
            val s = br.readLine()
            // 0: 소문자, 1: 대문자, 2: 숫자, 3: 공백
            val answer = IntArray(4)
            for (c in s) {
                if (c.code in 'a'.code .. 'z'.code) {
                    answer[0]++
                }
                else if (c.code in 'A'.code .. 'Z'.code) {
                    answer[1]++
                }
                else if (c.code in '0'.code .. '9'.code) {
                    answer[2]++
                }
                else {
                    answer[3]++
                }
            }
            bw.write("${answer[0]} ${answer[1]} ${answer[2]} ${answer[3]}")
            bw.newLine()
        } catch (e: Exception) {
            break
        }
    }
    br.close()
    bw.flush()
    bw.close()
}
