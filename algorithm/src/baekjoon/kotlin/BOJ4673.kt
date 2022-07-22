package baekjoon

fun numberConstructor(num: Int): Int {
    var tmp = num
    var result = 0

    if (num > 9) {
        if (num > 99) {
            if (num > 999) {
                result += (tmp / 1000)
                tmp %= 1000
            }
            result += (tmp / 100)
            tmp %= 100
        }
        result += (tmp / 10)
        tmp %= 10
    }
    result += (tmp + num)

    return result
}

fun main() {
    var num = 0
    var i = 1
    val array = BooleanArray(10001) { true }

    while (i <= 10000) {
        num = numberConstructor(i)
        if (num <= 10000) {
            array[num] = false
        }
        i++
    }

    i = 1
    while (i <= 10000) {
        if (array[i]) {
            println(i)
        }
        i++
    }
}