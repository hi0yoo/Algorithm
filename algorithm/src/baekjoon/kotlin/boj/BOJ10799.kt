package baekjoon.kotlin.boj

import java.util.Stack

fun main() {
    var result = 0
    val stack = Stack<Char>()

    val s = readln()
    var lastChar = ' '
    for (c in s) {
        when (c) {
            '(' -> stack.push(c)
            else -> {
                stack.pop()
                if (lastChar == '(') result += stack.size else result++
            }
        }
        lastChar = c
    }
    println(result)
}
