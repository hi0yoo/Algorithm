package baekjoon.kotlin.boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

// TODO Iterator 공부
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    val list = LinkedList<Char>()
    for (e in s) list.add(e)
    val it = list.listIterator()
    while (it.hasNext()) it.next()

    val m = br.readLine().toInt() // 명령어 갯수
    for (i in 1 .. m) {
        val command = br.readLine()
        when (command[0]) {
            'L' -> if (it.hasPrevious()) it.previous()
            'D' -> if (it.hasNext()) it.next()
            'B' -> if (it.hasPrevious()) {
                it.previous()
                it.remove()
            }
            else -> it.add(command[2])
        }
    }

    println(list.toCharArray())
}
