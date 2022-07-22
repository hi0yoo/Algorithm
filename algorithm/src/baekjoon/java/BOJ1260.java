package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    static ArrayList<Integer>[] a;
    static int n;
    static int m;
    static boolean[] dfsCheck;
    static boolean[] bfsCheck;
    static StringBuffer sb = new StringBuffer();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        a = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            a[e1].add(e2);
            a[e2].add(e1);
        }

        for (int i = 1; i < n + 1; i++) {
            a[i].sort(((o1, o2) -> o1 - o2));
        }

        dfsCheck = new boolean[n + 1];
        dfsCheck[0] = true;
        dfsCheck[v] = true;
        bfsCheck = new boolean[n + 1];
        bfsCheck[0] = true;

        dfs(v);
        System.out.println(sb);

        sb = new StringBuffer();
        queue.add(v);
        bfsCheck[v] = true;
        bfs();
        System.out.println(sb);
    }

    static private void dfs(int start) {
        sb.append(start + " ");
        for (int i = 0; i < a[start].size(); i++) {
            int num = a[start].get(i);
            if (!dfsCheck[num]) {
                dfsCheck[num] = true;
                dfs(num);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append(poll + " ");
            for (int i = 0; i < a[poll].size(); i++) {
                int num = a[poll].get(i);
                if (!bfsCheck[num]) {
                    bfsCheck[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}
