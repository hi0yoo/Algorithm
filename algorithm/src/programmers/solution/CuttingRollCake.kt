package programmers.solution

/*
롤케이크를 두조각으로 자른다.
케이크 조각에 동일한 가짓 수의 토핑이 올라가면 공평하다.
케이크 조각 크기와 조각에 올라간 토핑의 수는 상관 없다.

케이크 : 1, 2, 1, 3, 1, 4, 1, 2
3, 1 사이(인덱스 3 뒤)를 자르면 앞은 1, 2, 3 / 뒤는 1, 2, 4 -> 각 3종류로 동일
1, 4 사이(인덱스 4 뒤)를 잘라도 1, 2, 3, / 1, 2, 4 -> 각 3종류로 동일
공평하게 자르지 못하는 경우도 있음. 0 리턴
-> 롤 케이크를 공평하게 자르는 방법의 수를 리턴
(topping 길이는 1,000,000 이하의 자연수)
(topping 원소는 10,000 이하의 자연수)

-> ->
원소 갯수가 1이면 0 리턴
원소 갯수가 2이면 자르는 경우 1가지
원소 갯수가 3이면 자르는 경우 2가지
원소 갯수가 4이면 자르는 경우 3가지
원소 갯수가 k이면 자르는 경우 k-1가지

topping 한 바퀴 돌면서 두 조각으로 나눔.
1개의 토핑과 n-1개의 토핑을 갖도록 나누고, 토핑 종류 갯수가 동일한지 여부 판단
각각 [2개, n-2개], [3개, n-3개], ..., [n-1개, 1개]로 변경해가며 토핑 종류 갯수가 동일한지 여부 판단
 */
class CuttingRollCake {

    fun solution(toppings: IntArray): Int {
        var answer = 0

        // 원소 갯수가 1보다 클 때만 수행
        if (toppings.size > 1) {
            val sliceA = mutableMapOf<Int, Int>()
            val sliceB = mutableMapOf<Int, Int>()

            // A 조각에 처음 1개의 토핑, 나머지 토핑은 B 조각에 있도록 초기화
            var sliceBStartIdx = 1
            add(toppings[sliceBStartIdx - 1], sliceA)
            for (i in sliceBStartIdx until toppings.size) add(toppings[i], sliceB)
            // 두 조각 토핑 종류 갯수가 동일하면 answer + 1
            if (sliceA.size == sliceB.size) answer++

            // B 조각의 토핑 개수가 1개 남을 때 까지 반복
            while (sliceBStartIdx < toppings.size - 1) {
                // B 조각에 토핑 제거
                minus(toppings[sliceBStartIdx], sliceB)
                // A 조각에 토핑 추가
                add(toppings[sliceBStartIdx], sliceA)
                // 두 조각 토핑 종류 갯수가 동일하면 answer + 1
                if (sliceA.size == sliceB.size) answer++
                // B 조각 시작 시점 변경
                sliceBStartIdx++
            }
        }

        return answer
    }

    fun minus(num: Int, map: MutableMap<Int, Int>) {
        val toppingCount = map[num]!!
        if (toppingCount <= 1) {
            map.remove(num)
        } else {
            map[num] = toppingCount - 1
        }
    }

    fun add(num: Int, map: MutableMap<Int, Int>) {
        val toppingCount = map.getOrDefault(num, 0)
        map[num] = toppingCount + 1
    }
}