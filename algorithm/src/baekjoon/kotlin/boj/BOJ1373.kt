package baekjoon.kotlin.boj

import java.util.Stack

fun main() = with(StringBuffer()) {
    val s = readln().toCharArray()
    val stack = Stack<Int>()
    var count = 0
    var sum = 0
    for (i in s.size - 1 downTo 0) {
        sum += (s[i].code - 48) * (if (count == 0) 1 else 2 * count)
        count++
        if (count == 3) {
            count = 0
            stack.push(sum)
            sum = 0
        }
    }
    if (stack.isEmpty()) {
        append(0)
    }
    else {
        if (sum == 0) {
            if (stack.peek() == 0) stack.pop()
            while (!stack.isEmpty()) append(stack.pop())
        }
        else {
            append(sum)
            while (!stack.isEmpty()) append(stack.pop())
        }
    }
    println(toString())
}
