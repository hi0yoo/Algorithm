package baekjoon.kotlin.boj

import java.util.*

fun main() {
    val split = readln()
    val sb = StringBuffer()
    val stack = Stack<Char>()
    for (c in split) {
        when (c) {
            '+', '-', '*', '/' -> {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) sb.append(stack.pop())
                stack.push(c)
            }
            '(' -> stack.push(c)
            ')' -> {
                while (!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop())
                stack.pop()
            }
            else -> sb.append(c)
        }
    }

    while (!stack.isEmpty()) {
        sb.append(stack.pop())
    }

    println(sb)
}

fun priority(op: Char) = when (op) {
    '(', ')' -> 0
    '+', '-' -> 1
    '*', '/' -> 2
    else -> -1
}
