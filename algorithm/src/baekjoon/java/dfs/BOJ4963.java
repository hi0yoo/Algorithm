package baekjoon.java.dfs;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    private static StringTokenizer st;
    private static int[][] node;
    private static boolean[][] visitied;
    private static int w;
    private static int h;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            node = new int[h][w];
            visitied = new boolean[h][w];
            count = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    node[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (node[i][j] == 1 && !visitied[i][j]) {
                        dfs(j, i);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visitied[y][x] = true;
        if (y-1 >= 0 && node[y-1][x] == 1 && !visitied[y-1][x]) {
            dfs(x, y-1);
        }
        if (y+1 < h && node[y+1][x] == 1 && !visitied[y+1][x]) {
            dfs(x, y+1);
        }
        if (x-1 >= 0 && node[y][x-1] == 1 && !visitied[y][x-1]) {
            dfs(x-1, y);
        }
        if (x+1 < w && node[y][x+1] == 1 && !visitied[y][x+1]) {
            dfs(x+1, y);
        }

        if (y-1 >= 0 && x-1 >= 0 && node[y-1][x-1] == 1 && !visitied[y-1][x-1]) {
            dfs(x-1, y-1);
        }
        if (y-1 >= 0 && x+1 < w && node[y-1][x+1] == 1 && !visitied[y-1][x+1]) {
            dfs(x+1, y-1);
        }
        if (y+1 < h && x-1 >= 0 && node[y+1][x-1] == 1 && !visitied[y+1][x-1]) {
            dfs(x-1, y+1);
        }
        if (y+1 < h && x+1 < w && node[y+1][x+1] == 1 && !visitied[y+1][x+1]) {
            dfs(x+1, y+1);
        }
    }
}
