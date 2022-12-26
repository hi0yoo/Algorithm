package programmers.solution;

import java.util.Arrays;

public class TableHashFunction {
    /*
    열(세로)은 컬럼
    행(가로)은 튜플
    data[행][열]

    1. 테이블의 튜플을 col 번째 컬럼의 값을 기준으로 오름차순 정렬을 한다.
        만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬한다.
    2. 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
        i : i번째 행의 튜플
        int S_i = 0;
        for (int j = 0; j < data[i].length; j++) {
            S_i = (data[i][j] % i);
        }
    3. row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
        int result = 0;
        if (i >= row_begin && i <= row_end) {
            result = result ^ S_i;
        }

    data 길이 1 ~ 2,500
    data[k] 길이 1 ~ 500
    data[i][j] 크기 1 ~ 1,000,000
    data[i][j] 는 i+1 번째 튜플, j+1 번째 컬럼의 값을 의미
    data[k][0]는 기본키로 중복되지 않는다.

    TableHashFunction tableHashFunction = new TableHashFunction();
    int[][] data = {
        {2, 2, 6},
        {1, 5, 10},
        {4, 2, 9},
        {3, 8, 3}
    };
    int col = 2;
    int row_begin = 2;
    int row_end = 3;
    System.out.println(tableHashFunction.solution(data, col, row_begin, row_end));
     */
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        // col 번째 컬럼(data[i][col])을 기준으로 오름차순 정렬, 같은 값은 첫번째 컬럼인 기본키(data[i][0])를 기준으로 내림차순 정렬
        // 배열은 0부터 시작하고, 문제에서는 1부터 시작함. 따라서 코드에서는 col-1이 문제의 col 과 같다.
        Arrays.sort(data, ((o1, o2) -> o1[col - 1] != o2[col - 1] ? o1[col - 1] - o2[col - 1] : o2[0] - o1[0]));
        // 모든 튜플에 대해 반복 수행
        for (int i = row_begin - 1; i < row_end; i++) {
            int S_i = 0;
            // 각 컬럼을 i+1로 나눈 값을 더함
            for (int d : data[i]) S_i += (d % (i + 1));
            // XOR 누적
            answer = (answer ^ S_i);
        }

        return answer;
    }
}
