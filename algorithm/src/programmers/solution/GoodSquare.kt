package programmers.solution

class GoodSquare {
    /*
    w : 가로
    h : 세로
    자른 선 방정식 : y = (h / w) x
     */

    fun solution(w: Int, h: Int): Long {
        return (0L until w.toLong()).reduce { total, i -> total + (h.toLong() * i) / w } * 2
    }
}