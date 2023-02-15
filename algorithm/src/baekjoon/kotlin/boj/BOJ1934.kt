package baekjoon.kotlin.boj

fun main() {
    val t = readln().toInt()
    for (i in 0 until t) {
        val arr = readln().split(" ").map { it.toInt() }
        println(arr[0] * arr[1] / gcd(arr[0], arr[1]))
    }
}

private fun gcd(n1: Int, n2: Int): Int {
    val max = if (n1 > n2) n1 else n2
    val min = if (max == n1) n2 else n1
    if (max % min == 0) return min
    return gcd(min, max % min)
}
