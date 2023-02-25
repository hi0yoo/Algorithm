package baekjoon.kotlin.boj

import java.util.*

fun main() {
    val nk = readln().split(" ").map { it.toInt() }
    val arr = IntArray(100_001) { -1 }
    val parent = IntArray(100_001)
    val queue: Queue<Int> = LinkedList()
    queue.add(nk[0])
    var answer = -1
    while (true) {
        answer++
        for (i in 1..queue.size) {
            val poll = queue.poll()
            arr[poll] = answer
            if (poll == nk[1]) {
                println(arr[poll])
                val stack = Stack<Int>()
                var idx = poll
                while (idx != nk[0]) {
                    stack.push(idx)
                    idx = parent[idx]
                }
                stack.push(idx)

                while (!stack.isEmpty()) print("${stack.pop()} ")
                return
            }

            if (poll - 1 >= 0 && arr[poll - 1] == -1) {
                queue.add(poll - 1)
                arr[poll - 1] = answer
                parent[poll - 1] = poll
            }
            if (poll + 1 <= 100_000 && arr[poll + 1] == -1) {
                queue.add(poll + 1)
                arr[poll + 1] = answer
                parent[poll + 1] = poll
            }
            if (poll * 2 <= 100_000 && arr[poll * 2] == -1) {
                queue.add(poll * 2)
                arr[poll * 2] = answer
                parent[poll * 2] = poll
            }
        }
    }
}
