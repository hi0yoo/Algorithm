package baekjoon.kotlin.boj

import java.util.StringTokenizer

fun sameCount(a:Int, b:Int, c:Int):Int {
    if (a == b) {
        if (b == c) {
            return 3
        }
        return 2
    } else if (b == c) {
        if (c == a) {
            return 3
        }
        return 2
    } else if (a == c) {
        if (a == b) {
            return 3
        }
        return 2
    }
    return 1
}

fun sameNumber(a:Int, b:Int, c:Int):Int {
    if (a == b || a == c) {
        return a
    }

    if (b == c) {
        return b
    }

    return 0
}

fun max(a:Int, b:Int, c:Int):Int {
    var max = a
    if (max < b) {
        max = b
    }
    if (max < c) {
        max = c
    }
    return max
}

fun main() {
    val st = StringTokenizer(readLine())
    val a = Integer.parseInt(st.nextToken())
    val b = Integer.parseInt(st.nextToken())
    val c = Integer.parseInt(st.nextToken())
    val sameCount = sameCount(a, b, c)
    var reward = 0

    if (sameCount == 3) {
        reward = 10000 + a * 1000
    } else if (sameCount == 2) {
        reward = 1000 + sameNumber(a, b, c) * 100
    } else {
        reward = 100 * max(a, b, c)
    }

    println(reward)
}