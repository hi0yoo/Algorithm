package baekjoon.java.bfs;

import java.io.*;
import java.util.*;

public class BOJ7576 {

    private static StringTokenizer st;
    private static int w;
    private static int h;
    private static int[][] node;
    private static int zeroCount = 0;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        node = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) {
                    zeroCount++;
                }
                node[i][j] = c;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue1 = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (node[i][j] == 1) {
                    queue.add(new Node(j, i));
                }
            }
        }

        while (zeroCount > 0) {
            if (queue.isEmpty()) {
                break;
            }
            result++;
            while (!queue.isEmpty()) {
                queue1.add(queue.poll());
            }
            while (!queue1.isEmpty()) {
                Node point = queue1.poll();
                int x = point.getX();
                int y = point.getY();
                if (x - 1 >= 0 && node[y][x-1] == 0) {
                    extracted(queue, x-1, y);
                }
                if (x + 1 < w && node[y][x+1] == 0) {
                    extracted(queue, x+1, y);
                }
                if (y - 1 >= 0 && node[y-1][x] == 0) {
                    extracted(queue, x, y-1);
                }
                if (y + 1 < h && node[y+1][x] == 0) {
                    extracted(queue, x, y+1);
                }
            }
        }

        if (zeroCount > 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void extracted(Queue<Node> queue, int x, int y) {
        node[y][x] = 1;
        zeroCount--;
        queue.add(new Node(x, y));
    }

    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
