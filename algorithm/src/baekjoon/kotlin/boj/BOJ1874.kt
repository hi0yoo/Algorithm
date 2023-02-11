package baekjoon.kotlin.boj

import java.util.Stack

fun main() {
    var flag = true
    val sb = StringBuffer()
    val n = readln().toInt()
    val stack: Stack<Int> = Stack()
    var count = 1

    for (i in 1 .. n) {
        val num = readln().toInt()
        while (count <= num) {
            stack.push(count++)
            sb.append("+\n")
        }

        if (!stack.isEmpty() && stack.peek() == num) {
            stack.pop()
            sb.append("-\n")
        } else {
            println("NO")
            flag = false
            break
        }
    }

    if (flag) println(sb)
}
