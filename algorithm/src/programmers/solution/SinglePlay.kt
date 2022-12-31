package programmers.solution

/*
숫자 카드 더미에는 카드가 총 100장, 1부터 100까지

2 <= n <= 100
n >= cards[i]
boxCount = cards.length

mix box -> boxes, 박스 순서대로 1번부터 번호 붙임
k는 랜덤
boxes[k] open -> p
boxes[p] open -> q
boxes[q] open -> ....
boxes[random]이 이미 open 되어 있을 때 까지 반복
-> 1번 그룹

위 과정 한번 더 진행
-> 2번 그룹

만약 2번 그룹이 안 만들어지면(1번 진행 후 더 이상 진행할 박스가 없다면) 0점 리턴 후 종료

return 그룹 1 상자 수 * 그룹 2 상자 수

이 때 얻을 수 있는 최고 점수는?

-> ->
1부터 n 까지의 카드가 존재 (n <= 100)
1부터 n 까지의 번호를 갖는 박스가 존재
박스에는 1부터 n 까지 값 중 랜덤으로 카드가 존재
섞인 박스를 표현하는 cards 배열 주어짐
-> cards.length 가 n임


dfs?
visited 배열 선언
카드 번호가 k 이면, 인덱스는 k - 1
 */
class SinglePlay {
    lateinit var visited: BooleanArray

    fun solution(cards: IntArray): Int {
        visited = BooleanArray(cards.size)

        var group1 = 0
        var group2 = 0

        for (i in cards.indices) {
            if (!visited[i]) {
                visited[i] = true
                val count = dfs(i, cards)
                if (count > group1) {
                    group2 = group1
                    group1 = count
                } else if (count > group2) group2 = count
            }
        }

        return group1 * group2
    }

    fun dfs(idx: Int, cards: IntArray): Int {
        var count = 1
        val nextBoxIdx = cards[idx] - 1
        if (!visited[nextBoxIdx]) {
            visited[nextBoxIdx] = true
            count = dfs(nextBoxIdx, cards) + 1
        }
        return count
    }
}