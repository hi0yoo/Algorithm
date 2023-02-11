package baekjoon.kotlin.boj

var selfNumber: BooleanArray = BooleanArray(10001) { true }

fun main() {
    selfNumber[0] = false
    for (i in 1..10000) {
        deleteNumber(i)
    }
    selfNumber.forEachIndexed { idx, bool -> if (bool) println(idx) }
}

fun deleteNumber(start: Int) {
    var calNum = cal(start)
    while (calNum <= 10000) {
        selfNumber[calNum] = false
        calNum = cal(calNum)
    }
}

fun cal(number: Int): Int {
    var result = number
    var num = number
    while (num / 10 > 0) {
        result += num % 10
        num /= 10
    }
    return result + num
}
