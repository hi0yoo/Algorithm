package baekjoon

fun cycle(num:Int) : Int {
    var result = num
    var tens = 0
    var units = 0
    var count = 0

    do {
        tens = result / 10
        units = result % 10
        result = (units * 10) + ((tens + units) % 10)
        count++
    } while (result != num)

    return count
}

fun main() {
    val n = readLine()!!.toInt()

    println(cycle(n))
}