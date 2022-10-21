package baekjoon.java.dfs;

import java.io.*;
import java.util.*;

public class BOJ2667 {
    private static int[][] node;
    private static boolean[][] visited;
    private static int num;
    private static int[] counts;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                node[i][j] = Integer.parseInt(split[j]);
            }
        }
        num = 0;
        counts = new int[n*n];

        bfs(0, 0);

        System.out.println(num);
        Arrays.sort(counts);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println(counts[i]);
            }
        }
    }

    private static void bfs(int x, int y) {
        int pointX = x;
        int pointY = y;
        Queue<Integer> queue = new LinkedList<>();
        while (pointX < n && pointY < n) {
            if (node[pointX][pointY] == 1 && !visited[pointX][pointY]) {
                visited[pointX][pointY] = true;
                queue.add(pointX * n + pointY);
                num++;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    counts[num]++;
                    int a = poll / n;
                    int b = poll % n;
                    node[a][b] = num;
                    if (a - 1 >= 0 && b < n && node[a-1][b] == 1 && !visited[a-1][b]) {
                        queue.add((a-1)*n+b);
                        visited[a-1][b] = true;
                    }
                    if (a + 1 < n && b < n && node[a+1][b] == 1 && !visited[a+1][b]) {
                        queue.add((a+1)*n+b);
                        visited[a+1][b] = true;
                    }
                    if (a < n && b - 1 >= 0 && node[a][b-1] == 1 && !visited[a][b-1]) {
                        queue.add(a*n+(b-1));
                        visited[a][b-1] = true;
                    }
                    if (a < n && b + 1 < n && node[a][b+1] == 1 && !visited[a][b+1]) {
                        queue.add(a*n+(b+1));
                        visited[a][b+1] = true;
                    }
                }
            }
            if ((pointY + 1) % n == 0) {
                pointX++;
                pointY = 0;
            } else {
                pointY++;
            }
        }
    }
}
