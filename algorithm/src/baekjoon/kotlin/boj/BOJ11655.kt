package baekjoon.kotlin.boj

import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    for (c in readln()) {
        when (c.code) {
            in 'A'.code .. 'Z'.code, in 'a'.code .. 'z'.code -> {
                var code = c.code + 13
                if (code in 'Z'.code + 1 .. 'Z'.code +13) code -= 26
                if (code in 'z'.code + 1 .. 'z'.code +13) code -= 26
                bw.write(code)
            }
            else -> bw.write(c.code)
        }
    }
    bw.flush()
    bw.close()
}
