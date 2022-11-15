package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun main() {
    val stringTokenizer = StringTokenizer(readLine())
    val h = Integer.parseInt(stringTokenizer.nextToken())
    val m = Integer.parseInt(stringTokenizer.nextToken())
    var alarmHour = h
    var alarmMinute = m - 45

    if (alarmMinute < 0) {
        if (--alarmHour < 0) {
            alarmHour += 24
        }
        alarmMinute += 60
    }

    println("$alarmHour $alarmMinute")

}