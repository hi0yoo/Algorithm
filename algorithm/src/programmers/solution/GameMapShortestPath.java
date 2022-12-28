package programmers.solution;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestPath {
    /*
    5 * 5 map
    (1, 1) 시작
    (5, 5) 목표 지점
    int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
    };
    -> 11

    int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1}
    };
    -> -1
     */
    // 맵 세로 크기
    private static int rowSize;
    // 맵 가로 크기
    private static int colSize;
    // {x, y} 형식으로 큐에 삽입
    private static Queue<int[]> queue = new LinkedList<>();

    public int solution(int[][] maps) {
        int answer = 0;

        rowSize = maps.length;
        colSize = maps[0].length;

        // 1, 1 위치에서 시작
        visit(0, 0, maps);

        while (!queue.isEmpty()) {
            // 반복마다 이동한 횟수 추가
            answer++;
            int currentSize = queue.size();
            // 현재 큐에 있는 수 만큼 반복
            while (currentSize > 0) {
                int[] poll = queue.poll();
                currentSize--;
                // 상대 진영에 도착했으면 리턴
                if (poll[0] == colSize - 1 && poll[1] == rowSize - 1) return answer;

                // 상하좌우 방문
                visit(poll[0] - 1, poll[1], maps);
                visit(poll[0] + 1, poll[1], maps);
                visit(poll[0], poll[1] - 1, maps);
                visit(poll[0], poll[1] + 1, maps);
            }
        }
        // 리턴되지 않았으면 도착 불가능함.
        return -1;
    }

    private void visit(int x, int y, int[][] maps) {
        // 방문할 수 있는 곳이면 방문
        if (x >= 0 && x < colSize && y >= 0 && y < rowSize && maps[y][x] == 1) {
            queue.add(new int[]{x, y});
            maps[y][x] = 0;
        }
    }
}
