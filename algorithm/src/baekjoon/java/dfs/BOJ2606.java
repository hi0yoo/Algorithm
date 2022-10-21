package baekjoon.java.dfs;

import java.io.*;
import java.util.*;

public class BOJ2606 {
    private static boolean[] visited;
    private static int[][] node;
    private static int n;
    private static int m;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        node = new int[n][n];
        count = 0;

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            node[a][b] = 1;
            node[b][a] = 1;
        }

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int num) {
        visited[num] = true;
        for (int i = 0; i < n; i++) {
            if (node[num][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
