package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun selectMax(a: IntArray):Int {
    var result = a[0]

    for (i in 1 until a.size) {
        if (result < a[i]) {
            result = a[i]
        }
    }
    return result
}

fun main() {
    val num = readLine()!!.toInt()
    val intArray = IntArray(num)
    var sum = 0.toDouble()

    val st = StringTokenizer(readLine())
    for (i in 0 until num) {
        intArray[i] = st.nextToken().toInt()
    }

    val max = selectMax(intArray)

    for (i in 0 until num) {
        sum += (intArray[i].toDouble() / max.toDouble()) * 100
    }

    println(sum / num)

}