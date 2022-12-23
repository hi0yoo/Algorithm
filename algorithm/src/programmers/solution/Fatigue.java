package programmers.solution;

public class Fatigue {
//    int k = 80;
//    int[][] dungeons = {
//            {80, 20},
//            {50, 40},
//            {30, 10}
//    };
    // result=3

    public int solution(int k, int[][] dungeons) {
        // dungeons[k][0] : 최소 필요 피로도
        // dungeons[k][1] : 소모 피로도
        return dfs(k, dungeons);
    }

    private int dfs(int k, int[][] dungeons) {
        int count = 0;
        for (int[] arr : dungeons) {
            int required = arr[0], consumed = arr[1];
            if (k >= arr[0]) {
                // 방문 처리
                arr[0] = 9999;
                // 더 큰 값 저장
                count = Math.max(count, 1 + dfs(k - consumed, dungeons));
                // 방문 처리 원상 복귀
                arr[0] = required;
            }
        }
        // 어느 곳도 방문할 수 없다면 0 반환
        return count;
    }
}
