package programmers.solution;

import java.util.Arrays;
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
    private static int rowSize;
    private static int colSize;
    private static int[][] map;
    private static Queue<Node> queue = new LinkedList<>();

    public int solution(int[][] maps) {
        int answer = 0;

        rowSize = maps.length;
        colSize = maps[0].length;
        map = new int[rowSize + 1][colSize + 1];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                map[i + 1][j + 1] = maps[i][j];
            }
        }

        Node start = new Node(1, 1);
        queue.add(start);
        map[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            while (currentSize > 0) {
                Node poll = queue.poll();
                if (poll.x == colSize && poll.y == rowSize) {
                    return answer + 1;
                }
                if (poll.canLeft()) {
                    visit(poll.y, poll.x - 1);
                }
                if (poll.canRight()) {
                    visit(poll.y, poll.x + 1);
                }
                if (poll.canTop()) {
                    visit(poll.y - 1, poll.x);
                }
                if (poll.canBottom()) {
                    visit(poll.y + 1, poll.x);
                }
                currentSize--;
            }
            answer++;
        }
        if (map[rowSize][colSize] == 1) {
            return -1;
        }
        return answer;
    }

    private void visit(int y, int x) {
        queue.add(new Node(x, y));
        map[y][x] = 0;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canLeft() {
            return x - 1 > 0 && map[y][x - 1] == 1;
        }

        public boolean canRight() {
            return x + 1 <= colSize && map[y][x + 1] == 1;
        }

        public boolean canTop() {
            return y - 1 > 0 && map[y - 1][x] == 1;
        }

        public boolean canBottom() {
            return y + 1 <= rowSize && map[y + 1][x] == 1;
        }
    }
}
