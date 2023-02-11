package baekjoon.kotlin.boj

// deque
fun main() {
    val n = readln().toInt()
    val arr = Array(n) { 0 }
    var front = 0
    var rear = n-1
    var size = 0
    for (i in 1..n) {
        val command = readln().split(" ")
        when (command[0]) {
            "push_front" -> {
                front = minusIdx(front, n)
                arr[front] = command[1].toInt()
                size++
            }
            "push_back" -> {
                rear = plusIdx(rear, n)
                arr[rear] = command[1].toInt()
                size++
            }
            "pop_front" -> {
                if (size == 0) {
                    println(-1)
                } else {
                    println(arr[front])
                    front = plusIdx(front, n)
                    size--
                }
            }
            "pop_back" -> {
                if (size == 0) {
                    println(-1)
                } else {
                    println(arr[rear])
                    rear = minusIdx(rear, n)
                    size--
                }
            }
            "size" -> println(size)
            "empty" -> println(if (size == 0) 1 else 0)
            "front" -> if (size == 0) println(-1) else println(arr[front])
            "back" -> if (size == 0) println(-1) else println(arr[rear])
        }
    }
}

fun minusIdx(idx: Int, arrSize: Int): Int {
    if (idx == 0) {
        return arrSize - 1
    }
    return idx - 1
}

fun plusIdx(idx: Int, arrSize: Int): Int {
    if (idx == arrSize - 1) {
        return 0
    }
    return idx + 1
}
