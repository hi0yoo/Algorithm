package baekjoon.kotlin.boj

import java.io.*
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var s = br.readLine()!!
    while (s != ".") {
        val stack = Stack<Char>()
        var flag = true
        for (c in s) {
            when (c) {
                '(', '[' -> stack.push(c)
                ')' -> if (stack.isEmpty() || stack.peek() != '(') {
                    // 스택이 비어있다면 종료
                    flag = false
                    break
                } else stack.pop()
                ']' -> if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false
                    break
                } else stack.pop()
            }
        }
        if (!stack.isEmpty()) bw.write("no")
        else {
            if (flag) bw.write("yes")
            else bw.write("no")
        }
        bw.newLine()

        s = br.readLine()!!
    }
    br.close()
    bw.flush()
    bw.close()
}

/*
while (s[0] != '.') {
        var flag = true
        for (c in s) {
            when (c) {
                '(' -> {
                    stack.push(c)
                }

                ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false
                        break
                    }
                }

                '[' -> {
                    stack.push(c)
                }

                ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false
                        break
                    }
                }
            }
        }
        if (stack.isEmpty()) if (flag) bw.write("yes") else bw.write("no") else bw.write("no")
        bw.newLine()

        s = br.readLine()!!
    }
 */
