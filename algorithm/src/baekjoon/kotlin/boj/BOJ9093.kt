package baekjoon.kotlin.boj

fun main() {
    val sb = StringBuffer()
    val t = readln().toInt()
    for (i in 1..t) {
        val words = readln().split(" ")
        val len = words.size
        var idx = 0
        while (idx < len) {
            val word = words[idx++]
            var lastIdx = word.length - 1
            while (lastIdx >= 0) {
                sb.append(word[lastIdx--])
            }
            sb.append(" ")
        }
        if (i != t) sb.append("\n")
    }
    println(sb)
}
