package baekjoon.kotlin.boj

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val intArr = IntArray(n)
    val numCount = IntArray(1_000_001)
    val st = StringTokenizer(readln())
    for (i in 0 until n) {
        val num = st.nextToken().toInt()
        intArr[i] = num
        numCount[num]++
    }

    val answer = IntArray(n)
    val stack = Stack<Int>()
    stack.push(0)
    for (i in 1 until n) {
        while (!stack.isEmpty() && numCount[intArr[i]] > numCount[intArr[stack.peek()]]) answer[stack.pop()] = intArr[i]
        stack.push(i)
    }

    while (!stack.isEmpty()) {
        answer[stack.pop()] = -1
    }

    val sb = StringBuffer()
    answer.forEach { sb.append("$it ") }
    println(sb)
}
