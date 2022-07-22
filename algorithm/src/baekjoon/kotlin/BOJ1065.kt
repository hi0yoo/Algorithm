package baekjoon

fun asd(x: Int): Int {
    val num = x
    val array = IntArray(4) {0}
    var pos = 0
    var count = 99
    var start = 111
    var tmp = 0

    if (num < 100) {
        return num
    } else if (num in 100 until 111) {
        return count
    } else {
        while (start <= num) {
            tmp = start++
            pos = array.size - 1
            while (tmp != 0) {
                array[pos--] = tmp % 10
                tmp /= 10
            }
            if (array[0] == 0 && array[2] - array[1] == array[3] - array[2]) {
                count++
            }
        }

        return count
    }
}

fun main() {
    val num = readLine()!!.toInt()

    println(asd(num))
}