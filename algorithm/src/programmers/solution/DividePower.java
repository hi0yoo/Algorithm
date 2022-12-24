package programmers.solution;

public class DividePower {
    /*
Test Case :

int n = 9;
int[][] wires = {
        {1, 3},
        {2, 3},
        {3, 4},
        {4, 5},
        {4, 6},
        {4, 7},
        {7, 8},
        {7, 9}
};
-> result = 3

int n = 4;
int[][] wires = {
    {1, 2},
    {2, 3},
    {3, 4}
};
-> result = 0

int n = 7;
int[][] wires = {
    {1, 2},
    {2, 7},
    {3, 7},
    {3, 4},
    {4, 5},
    {6, 7}
};
-> result = 0

System.out.println(dividePower.solution(n, wires));
     */
    public int solution(int n, int[][] wires) {
        // wires : 간선 정보
        // wires[k] : [v1, v2] <- v1과 v2가 서로 이어짐
        int answer = 9999;
        // 탐색 시작 노드 설정
        int startNode = 1;

        // i번째 간선 정보를 무시하고 탐색 진행
        for (int i = 0; i < wires.length; i++) {
            // arr : i번째 간선으로 주어진 전선을 잘랐을 때 각 노드의 연결 정보
            int[][] arr = getDividedTree(n, wires, i);
            // 방문한 노드 정보
            boolean[] visited = new boolean[n + 1];

            // 탐색 시작 노드부터 탐색 수행
            dfs(startNode, visited, arr);

            // 방문한 노드 수 카운트
            int visitedCount = getVisitedCount(visited);
            // 두 전력망의 송전탑 개수 차이(절대값)
            int sub = Math.abs(visitedCount - (n - visitedCount));
            // 기존 값과 비교하여 더 작은 값으로 저장
            answer = Math.min(answer, sub);
        }

        return answer;
    }

    private int[][] getDividedTree(int n, int[][] wires, int ignoreNode) {
        int[][] arr = new int[n + 1][n + 1];
        for (int j = 0; j < wires.length; j++) {
            if (j != ignoreNode) {
                arr[wires[j][0]][wires[j][1]] = 1;
                arr[wires[j][1]][wires[j][0]] = 1;
            }
        }
        return arr;
    }

    private void dfs(int node, boolean[] visited, int[][] arr) {
        visited[node] = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                dfs(i, visited, arr);
            }
        }
    }

    private int getVisitedCount(boolean[] visited) {
        int visitedCount = 0;
        for (boolean b : visited) {
            if (b) visitedCount++;
        }
        return visitedCount;
    }
}
