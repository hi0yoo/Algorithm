package study.dbna.bfsdfs;

public class ExampleDFS {
    public static void main(String[] args) {
        // 0 = A
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int current) {
        // 현재 노드를 방문 처리한다.
        visited[current] = true;
        char node = (char) (current + 65);
        writeCurrentNode(node);

        // 현재 노드와 인접한 노드를 찾는다.
        for (int i = 0; i < size; i++) {
            // 인접한 노드를 방문하지 않았다면, 해당 노드를 방문한다.
            if (arr[current][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void writeCurrentNode(char node) {
        sb.append(node);
        hasNext();
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

    private static void hasNext() {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            result = result && visited[i];
        }
        if (!result) {
            sb.append(" > ");
        }
    }
}
