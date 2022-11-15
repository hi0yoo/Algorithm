package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun main() {

    var st: StringTokenizer? = null;
    var stuNum = 0
    var scores = 0
    var higherThanAvgStuNum = 0

    val testNum = readLine()!!.toInt()

    var results = FloatArray(testNum)

    for (i in 0 until testNum) {
        st = StringTokenizer(readLine())
        stuNum = Integer.parseInt(st.nextToken())
        var scoreArray = Array(stuNum) { 0 }

        for (j in 0 until stuNum) {
            scoreArray[j] = st.nextToken().toInt()
            scores += scoreArray[j]
        }

        for (j in 0 until  stuNum) {
            if (scoreArray[j] > (scores / stuNum).toFloat()) {
                higherThanAvgStuNum++
            }
        }
        results[i] = higherThanAvgStuNum.toFloat() / stuNum.toFloat() * 100
        higherThanAvgStuNum = 0
        scores = 0

    }

    for (i in results) {
        println("%.3f%%".format(i))
    }

}