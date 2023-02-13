package baekjoon.kotlin.boj

import java.util.*

fun main() {
    val n = readln().toInt()
    val intArr = readln().split(" ").map { it.toInt() }
    val answer = IntArray(n)
    val stack = Stack<Int>()
    stack.push(0)

    for (i in 1 until n) {
        while (!stack.isEmpty() && intArr[i] > intArr[stack.peek()]) answer[stack.pop()] = intArr[i]
        stack.push(i)
    }

    while (!stack.isEmpty()) {
        answer[stack.pop()] = -1
    }

    val sb = StringBuffer()
    for (i in 0 until n) {
        sb.append(answer[i])
        if (i != n - 1) {
            sb.append(" ")
        }
    }
    println(sb)
}
