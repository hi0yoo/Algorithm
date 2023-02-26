package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1261 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) board[i][j] = Integer.parseInt(s[j - 1]);
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // {x, y, 1_count}
        PriorityQueue<int[]> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));
        queue.add(new int[]{1, 1, 0});
        visited[1][1] = true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] poll = queue.poll();
                if (poll[0] == m && poll[1] == n) {
                    System.out.println(poll[2]);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if (x >= 1 && x <= m && y >= 1 && y <= n && !visited[y][x]) {
                        int c = board[y][x] == 0 ? poll[2] : poll[2] + 1;
                        queue.add(new int[]{x, y, c});
                        visited[y][x] = true;
                    }
                }
            }
        }
    }
}
