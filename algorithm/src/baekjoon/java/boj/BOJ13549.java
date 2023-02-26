package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ13549 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == k) {
                    System.out.println(poll[1]);
                    return;
                }

                if (poll[0] * 2 <= 100_000 && !visited[poll[0] * 2]) {
                    queue.add(new int[]{poll[0] * 2, poll[1]});
                    visited[poll[0] * 2] = true;
                }
                if (poll[0] - 1 >= 0 && !visited[poll[0] - 1]) {
                    queue.add(new int[]{poll[0] - 1, poll[1] + 1});
                    visited[poll[0] - 1] = true;
                }
                if (poll[0] + 1 <= 100_000 && poll[0] < k && !visited[poll[0] + 1]) {
                    queue.add(new int[]{poll[0] + 1, poll[1] + 1});
                    visited[poll[0] + 1] = true;
                }
            }
        }
    }
}
