package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun max(a: IntArray):Int {
    var result = a[0]

    for (i in 1 until a.size) {
        if (result < a[i]) {
            result = a[i]
        }
    }
    return result
}

fun min(a: IntArray):Int {
    var result = a[0]

    for (i in 1 until a.size) {
        if (result > a[i]) {
            result = a[i]
        }
    }
    return result
}

fun main() {
    val num = readLine()!!.toInt()
    val intArray = IntArray(num)

    val st = StringTokenizer(readLine())

    for (i in 0 until intArray.size) {
        intArray[i] = Integer.parseInt(st.nextToken())
    }

    println("${min(intArray)} ${max(intArray)}")

}