package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ14226 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int current = 1;
        int clipBoard = 0;
        // (화면, 클립보드)
        boolean[][] visited = new boolean[1001][1001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{current, clipBoard});
        visited[current][clipBoard] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == s) {
                    System.out.println(count);
                    return;
                }

                // 복사
                if (!visited[poll[0]][poll[0]] && poll[0] != 0) {
                    queue.add(new int[]{poll[0], poll[0]});
                    visited[poll[0]][poll[0]] = true;
                }
                // 붙여넣기
                if (poll[0] + poll[1] <= 1000 && !visited[poll[0] + poll[1]][poll[1]] && poll[1] != 0) {
                    queue.add(new int[]{poll[0] + poll[1], poll[1]});
                    visited[poll[0] + poll[1]][poll[1]] = true;
                }
                // -1
                if (poll[0] > 2 && !visited[poll[0] - 1][poll[1]]) {
                    queue.add(new int[]{poll[0] - 1, poll[1]});
                    visited[poll[0] - 1][poll[1]] = true;
                }
            }
            count++;
        }
    }
}
