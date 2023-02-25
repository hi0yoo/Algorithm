package baekjoon.kotlin.boj

import java.util.*

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    val line = BooleanArray(100_001)

    val queue: Queue<Int> = LinkedList()
    queue.add(arr[0])
    var answer = -1
    while (!queue.isEmpty()) {
        answer++
        val count = queue.size
        for (i in 1..count) {
            val poll = queue.poll()
            if (poll == arr[1]) {
                println(answer)
                return
            }

            line[poll] = true
            if (poll - 1 >= 0 && !line[poll - 1]) queue.add(poll - 1)
            if (poll + 1 <= 100_000 && poll + 1 <= arr[1] && !line[poll + 1]) queue.add(poll + 1)
            if (poll * 2 <= 100_000 && !line[poll * 2]) queue.add(poll * 2)
        }
    }
}
