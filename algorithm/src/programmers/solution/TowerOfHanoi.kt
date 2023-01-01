package programmers.solution

/*
1. 한 번에 하나의 원판만 옮길 수 있음
2. 큰 원판이 작은 원판 위에 있어서는 안됨

기둥1의 n개의 원판을 기둥3으로 옮김.
최소 횟수가 되는 방법

정답 형식
[[startPillar, targetPillar], [startPillar, targetPillar], ...]

1번에서 시작.

n = 1
[1,3]

n = 2
[1,2], [1,3], [2,3]

n = 3
[1,3], [1,2], [3,2], [1,3], [2,1], [2,3], [1,3]

1 일때는 그냥 보낸다.
2 이상이면 n-1까지 경유지에 두고 n을 목적지에 둔 다음, n-1부터 경유지로부터 목적지로 가져온다.

만약 n = 5 이면
일단 5를 3번으로 보내야 한다.
그럴려면 1~4를 2번으로 보내야 하고, 1~4를 2번으로 보내려면 1~3은 3번, 1~2는 2번, 결국 1은 3번으로 가야 한다.
1이 3번으로 가고 나면, 2를 2번으로 옮기고, 1을 다시 2번으로 옮긴다.

여기서 알 수 있는 것은 n을 1번에서 3번으로 옮기고 싶다면, n-1은 2번을 경유해야 하고, 다시, n-1을 2번으로 옮기고 싶으니 n-2를 3번으로 옮겨야 한다는 것이다.
n-1의 목적지는 n이 목적지로 가기 위해 자신보다 작은 값들을 임시로 보내는 경유지이다.
따라서 function(current = n, from = 1, to = 3, via = 2)로 초기 함수를 호출하면,
n-1을 경유지로 보내기 위해 function(current = n-1, from = from, to = via, via = to)를 호출해야 한다.
이렇게 n-1까지 경유지로 다 보내고 나면 n을 목적지로 옮길 수 있다.

재귀함수
 */
class TowerOfHanoi {
    lateinit var list: MutableList<IntArray>

    fun solution(n: Int): Array<IntArray> {
        list = mutableListOf()

        hanoi(n, 1, 3, 2)

        return list.toTypedArray()
    }

    private fun hanoi(num: Int, from: Int, to: Int, via: Int) {
        if (num == 1) {
            list.add(intArrayOf(from, to))
        }
        else {
            hanoi(num - 1, from, via, to)
            list.add(intArrayOf(from, to))
            hanoi(num - 1, via, to, from)
        }
    }
}