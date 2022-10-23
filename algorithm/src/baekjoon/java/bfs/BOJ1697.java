package baekjoon.java.bfs;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    private static boolean[] line = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        line[n] = true;

        int size;
        int count = 0;
        while (true) {
            count++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current-1 == k || current+1 == k || current*2 == k) {
                    System.out.println(count);
                    return;
                }
                int left = left(current);
                if (left >= 1 && !line[left]) {
                    line[left] = true;
                    queue.add(left);
                }
                int right = right(current);
                if (right <= 100000 && !line[right]) {
                    line[right] = true;
                    queue.add(right);
                }
                int teleport = teleport(current);
                if (teleport <= 100000 && !line[teleport]) {
                    line[teleport] = true;
                    queue.add(teleport);
                }
            }
        }

    }

    private static int left(int num) {
        return num - 1;
    }

    private static int right(int num) {
        return num + 1;
    }

    private static int teleport(int num) {
        return num * 2;
    }
}
