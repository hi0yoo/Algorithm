package baekjoon.kotlin.boj

fun main() {
    val s = readln()
    val answer = IntArray(26)
    for (c in s) {
        answer[c.code - 97]++
    }
    for (i in answer) {
        print("$i ")
    }
}
