package baekjoon.kotlin.boj

import java.util.Stack

fun main() {
    val t = readln().toInt()
    for (i in 1..t) {
        solution(readln())
    }
}

fun solution(s: String) {
    val stack: Stack<Char> = Stack()
    val len = s.length

    for (i in 0 until len) {
        if (stack.isEmpty()) {
            stack.push(s[i])
        } else {
            if (s[i] == ')' && stack.peek() == '(') {
                stack.pop()
            } else {
                stack.push(s[i])
            }
        }
    }

    when (stack.size) {
        0 -> println("YES")
        else -> println("NO")
    }
}
