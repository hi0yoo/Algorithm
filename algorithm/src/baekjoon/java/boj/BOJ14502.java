package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ14502 {

    private static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int n;
    private static int m;
    private static int[][] map;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        int[][] virusMap = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) virusMap[i][j] = map[i][j];

        Queue<int[]> queue = new LinkedList<>();
        // int[] xy = {x, y}
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (virusMap[i][j] == 2) queue.add(new int[]{j, i});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = poll[0] + d[i][0];
                int dy = poll[1] + d[i][1];
                if (dx >= 0 && dy >= 0 && dx < m && dy < n && virusMap[dy][dx] == 0) {
                    virusMap[dy][dx] = 2;
                    queue.add(new int[]{dx, dy});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (virusMap[i][j] == 0) count++;
        answer = Math.max(answer, count);
    }
}
