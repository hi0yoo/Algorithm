package baekjoon.kotlin.boj

fun main() {
    var c2 = 0
    var c5 = 0
    val nums = readln().split(" ").map { it.toInt() }

    c2 = getCount(2, nums[0])
    c5 = getCount(5, nums[0])

    c2 -= getCount(2, nums[1])
    c5 -= getCount(5, nums[1])

    c2 -= getCount(2, nums[0] - nums[1])
    c5 -= getCount(5, nums[0] - nums[1])

    println(if (c2 > c5) c5 else c2)
}

fun getCount(target: Int, n: Int): Int {
    var count = 0
    var k = n
    while (k / target > 0) {
        count += k / target
        k /= target
    }
    return count
}
