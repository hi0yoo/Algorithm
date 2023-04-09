package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1916 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]>[] path = new List[n + 1];
        for (int i = 1; i <= n; i++) path[i] = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            path[start].add(new int[]{end, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] shortest = new int[n + 1];
        for (int i = 1; i <= n; i++) if (i != a) shortest[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{a, 0});

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];
            int nowCost = poll[1];
            if (!visited[now]) {
                visited[now] = true;
                for (int[] arr : path[now]) {
                    int dest = arr[0];
                    int destCost = arr[1];
                    if (now != dest) {
                        int fullCost = nowCost + destCost;
                        shortest[dest] = Math.min(shortest[dest], fullCost);
                        pq.add(new int[]{dest, shortest[dest]});
                    }
                }
            }
        }

        System.out.println(shortest[b]);
    }
}
