package baekjoon.kotlin.boj

fun main() {
    val s = readln().split(" ")
    val n1 = s[0].toInt()
    val n2 = s[1].toInt()
    val gcd = gcd(n1, n2)
    val lcm = n1 * n2 / gcd
    println(gcd)
    println(lcm)
}

private fun gcd(n1: Int, n2: Int): Int {
    val max = if (n1 > n2) n1 else n2
    val min = if (max == n1) n2 else n1
    if (max % min == 0) return min
    return gcd(min, max % min)
}
