package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1987 {

    private static int max = 0;
    private static int r;
    private static int c;
    private static char[][] board;
    private static boolean[][] visited;
    private static boolean[] chars = new boolean[26];
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[r][c];

        // 0,0 시작
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {
        if (!visited[y][x] && !chars[board[y][x] - 'A']) {
            visited[y][x] = true;
            chars[board[y][x] - 'A'] = true;
            max = Math.max(max, count + 1);

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] >= 0 && x + dx[i] < c && y + dy[i] >= 0 && y + dy[i] < r) {
                    dfs(x + dx[i], y + dy[i], count + 1);
                }
            }
            visited[y][x] = false;
            chars[board[y][x] - 'A'] = false;
        }
    }
}
