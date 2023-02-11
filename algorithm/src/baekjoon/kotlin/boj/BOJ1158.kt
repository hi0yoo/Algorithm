package baekjoon.kotlin.boj

import java.util.LinkedList

fun main() {
    val s = readln().split(" ")
    val n = s[0].toInt()
    val k = s[1].toInt()

    val linkedList = LinkedList<Int>()
    var listSize = n
    for (i in 1 .. n) {
        linkedList.add(i)
    }

    var start = 0
    print("<")
    while (listSize > 1) {
        var removeIdx = (start + k - 1) % listSize
        print(linkedList.removeAt(removeIdx))
        listSize--
        start = removeIdx
        print(", ")
    }
    print(linkedList[0])
    println(">")
}
