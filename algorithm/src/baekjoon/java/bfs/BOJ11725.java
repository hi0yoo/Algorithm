package baekjoon.java.bfs;

import java.io.*;
import java.util.*;

public class BOJ11725 {
    private static StringTokenizer st;
    private static List<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new List[n+1];
        for (int i = 0; i < n+1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        int[] parents = new int[n+1];
        boolean[] visitied = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visitied[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < nodes[poll].size(); j++) {
                    Integer integer = nodes[poll].get(j);
                    if (!visitied[integer]) {
                        parents[integer] = poll;
                        queue.add(integer);
                        visitied[integer] = true;
                    }
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            System.out.println(parents[i]);
        }
    }
}
