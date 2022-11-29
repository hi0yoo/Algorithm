package study.dbna.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class ExampleBFS {

    public static void main(String[] args) {
        // 0 = A
        bfs(0);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        // 현재 노드를 큐에 넣고 방문 처리한다.
        visit(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            char node = (char) (current + 65);
            writeCurrentNode(node);

            // 현재 노드와 인접한 노드를 찾는다.
            for (int i = 0; i < size; i++) {
                // 인접한 노드를 방문하지 않았다면, 해당 노드를 방문한다.
                if (arr[current][i] == 1 && !visited[i]) {
                    visit(i);
                }
            }
        }
    }

    private static void visit(int i) {
        queue.add(i);
        visited[i] = true;
    }

    private static void writeCurrentNode(char node) {
        sb.append(node);
        hasNext();
    }

    private static void hasNext() {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            result = result && visited[i];
        }
        if (!queue.isEmpty() || !result) {
            sb.append(" > ");
        }
    }

    private static int[][] arr = {
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}
    };
    private static int size = 10;
    private static boolean[] visited = new boolean[size];
    private static StringBuffer sb = new StringBuffer();
    private static Queue<Integer> queue = new LinkedList<>();
}
