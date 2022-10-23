package baekjoon.java.dfs;

import java.io.*;

public class BOJ10026 {
    private static int n;
    private static String[][] node;
    private static boolean[][] visitied;
    private static String current;
    private static int normalCount = 0;
    private static int uniqueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new String[n][n];
        visitied = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                node[i][j] = split[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitied[i][j]) {
                    current = node[i][j];
                    dfs(j, i);
                    normalCount++;
                }
            }
        }
        visitied = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitied[i][j]) {
                    current = node[i][j];
                    uniqueDfs(j, i);
                    uniqueCount++;
                }
            }
        }

        System.out.println(normalCount + " " + uniqueCount);
    }

    private static void dfs(int x, int y) {
        visitied[y][x] = true;
        if (x-1 >= 0 && node[y][x-1].equals(current) && !visitied[y][x-1]) {
            dfs(x-1, y);
        }
        if (x+1 < n && node[y][x+1].equals(current) && !visitied[y][x+1]) {
            dfs(x+1, y);
        }
        if (y-1 >= 0 && node[y-1][x].equals(current) && !visitied[y-1][x]) {
            dfs(x, y-1);
        }
        if (y+1 < n && node[y+1][x].equals(current) && !visitied[y+1][x]) {
            dfs(x, y+1);
        }
    }

    private static void uniqueDfs(int x, int y) {
        visitied[y][x] = true;
        if (x-1 >= 0 && canNext(node[y][x-1]) && !visitied[y][x-1]) {
            uniqueDfs(x-1, y);
        }
        if (x+1 < n && canNext(node[y][x+1]) && !visitied[y][x+1]) {
            uniqueDfs(x+1, y);
        }
        if (y-1 >= 0 && canNext(node[y-1][x]) && !visitied[y-1][x]) {
            uniqueDfs(x, y-1);
        }
        if (y+1 < n && canNext(node[y+1][x]) && !visitied[y+1][x]) {
            uniqueDfs(x, y+1);
        }
    }

    private static boolean canNext(String s) {
        if (current.equals("B")) {
            return s.equals("B");
        } else {
            return !s.equals("B");
        }
    }
}
