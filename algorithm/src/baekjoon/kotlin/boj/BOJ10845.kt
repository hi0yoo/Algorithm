package baekjoon.kotlin.boj

fun main() {
    val n = readln().toInt()
    val list = ArrayList<Int>()
    var first = 0 // pop마다 증가
    var last = -1 // push마다 증가
    var size = 0
    for (i in 1 .. n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push" -> {
                list.add(command[1].toInt())
                last++
                size++
            }
            "pop" -> {
                if (first > last) println(-1)
                else {
                    println(list[first++])
                    size--
                }
            }
            "size" -> println(size)
            "empty" -> println(if (first > last) 1 else 0)
            "front" -> {
                if (first > last) println(-1)
                else {
                    println(list[first])
                }
            }
            "back" -> {
                if (first > last) println(-1)
                else {
                    println(list[last])
                }
            }
        }
    }
}
