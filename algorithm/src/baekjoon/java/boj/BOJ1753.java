package baekjoon.java.boj;

import java.util.*;
import java.io.*;

public class BOJ1753 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        List<int[]>[] path = new List[v + 1];
        for (int i = 1; i <= v; i++) path[i] = new ArrayList<>();

        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            path[a].add(new int[]{b, w});
        }

        StringBuffer sb = new StringBuffer();

        int[] shortest = new int[v + 1];
        for (int a = 1; a <= v; a++) if (a != k) shortest[a] = Integer.MAX_VALUE;

        boolean[] visited = new boolean[v + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];
            if (!visited[now]) {
                visited[now] = true;

                for (int[] arr : path[now]) {
                    int dest = arr[0];
                    int pathCost = arr[1];
                    if (now != dest && pathCost != Integer.MAX_VALUE) {
                        int fullCost = poll[1] + pathCost;
                        shortest[dest] = Math.min(fullCost, shortest[dest]);
                        pq.add(new int[]{dest, fullCost});
                    }
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (shortest[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(shortest[i] + "\n");
        }

        System.out.println(sb);
    }
}
