package baekjoon.kotlin.boj

import java.util.*

fun main() {
    // A: 65
    val n = readln().toInt()
    val split = readln().toCharArray()
    val str = MutableList(split.size) {""}

    // arr[0]: 65: 'A'
    val arr = IntArray(n)
    for (i in 0 until n) arr[i] = readln().toInt()

    for (i in 0 until split.size) {
        val code = split[i].code
        if (code in 65..90) {
            str[i] = arr[code - 65].toString()
        }
        else {
            str[i] = code.toChar().toString()
        }
    }

    val stack = Stack<Double>()
    for (s in str) {
        when (s) {
            "+" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a+b)
            }
            "-" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a-b)
            }
            "*" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a*b)
            }
            "/" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a/b)
            }
            else -> stack.push(s.toDouble())
        }
    }

    println(String.format("%.2f", stack.pop()))
}
