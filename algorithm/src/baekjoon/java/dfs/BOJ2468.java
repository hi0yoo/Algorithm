package baekjoon.java.dfs;

import java.io.*;
import java.util.*;

public class BOJ2468 {

    private static StringTokenizer st;
    private static int[][] node;
    private static int max = 0;
    private static int min = 100;
    private static int count;
    private static int result = 0;
    private static int rain;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
                node[i][j] = num;
            }
        }
        for (rain = min - 1; rain <= max; rain++) {
            count = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n*n; i++) {
                int y = i / n;
                int x = i % n;
                if (node[y][x] > rain && !visited[y][x]) {
                    dfs(y, x);
                    count++;
                }
            }
            if (count > result) {
                result = count;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        if (y - 1 >= 0 && x < n && !visited[y-1][x] && node[y-1][x] > rain) {
            dfs(y-1,x);
        }
        if (y + 1 < n && x < n && !visited[y+1][x] && node[y+1][x] > rain) {
            dfs(y+1,x);
        }
        if (y < n && x - 1 >= 0 && !visited[y][x-1] && node[y][x-1] > rain) {
            dfs(y,x-1);
        }
        if (y < n && x + 1 < n && !visited[y][x+1] && node[y][x+1] > rain) {
            dfs(y,x+1);
        }
    }
}
