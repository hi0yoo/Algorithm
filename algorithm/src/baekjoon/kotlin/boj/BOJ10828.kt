package baekjoon.kotlin.boj

val arr: MutableList<Int> = mutableListOf()
var pointer: Int = -1

fun main() {
    val n = readln().toInt()
    for (i in 1 .. n) {
        getCount()
    }
}

fun getCount() {
    val input = readln()
    doSomething(input)
}

fun doSomething(command: String) {
    if (command.startsWith("push")) {
        val num = command.split(" ")[1].toInt()
        arr.add(++pointer, num)
    }
    else if (command.startsWith("pop")) {
        if (pointer == -1) {
            println(-1)
        } else {
            println(arr[pointer])
            arr.removeAt(pointer--)
        }
    }
    else if (command.startsWith("size")) {
        println(pointer + 1)
    }
    else if (command.startsWith("empty")) {
        if (pointer == -1) {
            println(1)
        } else {
            println(0)
        }
    }
    else if (command.startsWith("top")) {
        if (pointer == -1) {
            println(-1)
        } else {
            println(arr[pointer])
        }
    }
}
