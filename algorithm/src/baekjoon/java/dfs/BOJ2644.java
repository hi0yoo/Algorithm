package baekjoon.java.dfs;

import java.util.*;
import java.io.*;

public class BOJ2644 {

    private static List<Integer>[] lists;
    private static boolean[] visited;
    private static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 자식
            int y = Integer.parseInt(st.nextToken()); // 부모

            lists[x].add(y);
            lists[y].add(x);
        }

        dfs(a, 0, b);
        System.out.println(result);
    }

    private static void dfs(int start, int depth, int target) {
        visited[start] = true;
        if (start == target) {
            result = depth;
        }
        for (Integer num : lists[start]) {
            if (!visited[num]) {
                dfs(num, depth + 1, target);
            }
        }
    }
}
