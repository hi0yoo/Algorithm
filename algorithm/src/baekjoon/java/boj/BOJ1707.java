package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1707 {

    private static int v;
    private static int e;
    private static List<Integer>[] graph2;
    private static int[] visited;
    private static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            graph2 = new List[v + 1];
            for (int j = 1; j <= v; j++) graph2[j] = new ArrayList<>();

            e = Integer.parseInt(st.nextToken());
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph2[a].add(b);
                graph2[b].add(a);
            }

            // 방문하지 않았으면 0, 방문했으면 1 or 2 (group)
            visited = new int[v + 1];
            result = true;
            for (int j = 1; j <= v; j++) if (visited[j] == 0) dfs(j, 1);

            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void dfs(int node, int group) {
        visited[node] = group;
        if (!result) return;

        for (Integer i : graph2[node]) {
            if (visited[i] == visited[node]) {
                result = false;
                return;
            }
            if (visited[i] == 0) dfs(i, group != 1 ? 1 : 2);
        }
    }
}
