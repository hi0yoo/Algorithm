package baekjoon.kotlin.boj

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val arr = BooleanArray(1_000_001) { true }
    arr[0] = false
    arr[1] = false
    for (i in 2..1_000_000) if (arr[i]) for (j in i * 2 .. 1_000_000 step(i)) arr[j] = false

    var n = br.readLine()!!.toInt()
    while (n != 0) {
        var flag = false
        for (i in 2..n) if (arr[i] && arr[n - i]) {
            bw.write("$n = $i + ${n - i}")
            flag = true
            break
        }
        if (!flag) bw.write("Goldbach's conjecture is wrong.")

        bw.newLine()
        n = br.readLine()!!.toInt()
    }

    br.close()
    bw.flush()
    bw.close()
}
