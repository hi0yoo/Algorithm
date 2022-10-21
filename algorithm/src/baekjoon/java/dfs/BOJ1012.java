package baekjoon.java.dfs;

import java.io.*;
import java.util.*;

public class BOJ1012 {
    // 첫줄 테스트 케이스 개수 T
    // 각 테스트 케이스의 첫줄은 3개의 인자(가로길이 M, 세로길이 N, 배추의 위치 개수 K)
    // 다음 K줄은 배추의 위치
    private static StringTokenizer st;
    private static int count;
    private static int[][] node;
    private static int n;
    private static int m;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            node = new int[n][m];
            count = 0;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                node[y][x] = 1;
            }
            for (int j = 0; j < m*n; j++) {
                int y = j / m;
                int x = j % m;
                if (node[y][x] == 1) {
                    dfs(x, y);
                    count++;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        node[y][x] = 2;
        if (y-1 >= 0 && x < m && node[y-1][x] == 1) {
            dfs(x, y-1);
        }
        if (y+1 < n && x < m && node[y+1][x] == 1) {
            dfs(x, y+1);
        }
        if (y < n && x-1 >= 0 && node[y][x-1] == 1) {
            dfs(x-1, y);
        }
        if (y < n && x+1 < m && node[y][x+1] == 1) {
            dfs(x+1, y);
        }
    }
}
