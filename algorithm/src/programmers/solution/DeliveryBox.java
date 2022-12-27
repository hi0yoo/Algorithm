package programmers.solution;

import java.util.Stack;

public class DeliveryBox {
    /*
    상자 크기는 같다.
    1번부터 n번
    오름차순으로 전달된다.
    작은 번호의 상자부터 내릴 수 있다.
    내린 상자는 순서에 맞게 트럭에 실어야 한다.
    현재 상자가 트럭에 실을 순서가 아니면 보조 벨트에 보관한다.
    보조 벨트는 앞뒤로 이동이 가능, 가장 마지막에 넣은 상자부터 꺼낼 수 있음 <- 스택
    이래도 안되면 상자를 싣지 않는다.

    order 길이 1 ~ 1,000,000

    int[] order = {4, 3, 1, 2, 5};
    // result = 2
    int[] order = {5, 4, 3, 2, 1};
    // result = 5
     */
    public int solution(int[] order) {
        int answer = 0;

        // order 배열의 포인터
        int op = 0;
        // 컨테이너 벨트에서 현재 확인중인 박스 번호
        int currentBox = 1;
        // 보조 컨테이너 벨트
        Stack<Integer> assistanceBelt = new Stack<>();
        while (op < order.length) {
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호보다 크면
            if (order[op] > currentBox) {
                // 보조 벨트에 현재 박스를 보관한다.
                assistanceBelt.push(currentBox);
                currentBox++;
            }
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호와 같으면
            else if (order[op] == currentBox) {
                // 트럭에 싣는다.
                answer++;
                op++;
                currentBox++;
            }
            // 트럭에 실릴 박스의 번호가 현재 컨테이너 벨트의 박스 번호보다 작으면
            else {
                // 보조 벨트를 확인한다.
                while (!assistanceBelt.isEmpty() && order[op] == assistanceBelt.peek()) {
                    assistanceBelt.pop();
                    answer++;
                    op++;
                }
                // 트럭에 모두 실었으면 종료.
                // 또는 여전히 트럭에 실을 박스 번호가 현재 컨테이너 벨트의 박스 번호보다 작으면 종료.
                // 보조 벨트에도 원하는 박스가 없고, 컨테이너 벨트는 계속해서 더 큰 번호의 박스가 등장함.
                // 따라서 더 이상 박스를 싣지 못함.
                if (op >= order.length || order[op] < currentBox) {
                    break;
                }
            }
        }

        return answer;
    }
}
