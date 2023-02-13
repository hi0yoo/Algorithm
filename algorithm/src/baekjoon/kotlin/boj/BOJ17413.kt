package baekjoon.kotlin.boj

import java.util.Stack

fun main() {
    val sb = StringBuffer()
    val stack = Stack<Char>()

    val s = readln()

    var bool = false
    for (c in s) {
        if (c == '<') {
            popAll(stack, sb)
            bool = true
            sb.append(c)
        } else if (c == '>') {
            popAll(stack, sb)
            sb.append(c)
            bool = false
        } else {
            if (bool) {
                sb.append(c)
            } else {
                if (c == ' ') {
                    popAll(stack, sb)
                    sb.append(' ')
                } else {
                    stack.push(c)
                }
            }
        }
    }
    popAll(stack, sb)

    println(sb)
}

private fun popAll(stack: Stack<Char>, sb: StringBuffer) {
    while (!stack.isEmpty()) {
        sb.append(stack.pop())
    }
}
