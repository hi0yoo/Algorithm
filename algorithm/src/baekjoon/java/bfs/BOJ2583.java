package baekjoon.java.bfs;

import java.util.*;
import java.io.*;

public class BOJ2583 {

    private static int[][] board;
    private static boolean[][] visitied;
    private static Queue<Node> queue = new LinkedList<>();
    private static int m;
    private static int n;

    private static PriorityQueue<Integer> arr = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visitied = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            // 0,2  4,4
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    board[y][x] = 1;
                    visitied[y][x] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) { // x
            for (int j = 0; j < m; j++) { // y
                if (board[j][i] == 0 && !visitied[j][i]) {
                    queue.add(new Node(i, j));
                    visitied[j][i] = true;

                    int count = bfs();
                    arr.add(count);
                }
            }
        }

        System.out.println(arr.size());
        StringBuffer sb = new StringBuffer();
        while (!arr.isEmpty()) {
            sb.append(arr.poll() + " ");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Node poll = queue.poll();
            go(poll.left());
            go(poll.right());
            go(poll.top());
            go(poll.bottom());
        }
        return count;
    }

    private static void go(Node poll) {
        if (poll.canGo() && board[poll.y][poll.x] == 0) {
            queue.add(poll);
            visitied[poll.y][poll.x] = true;
        }
    }

    private static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canGo() {
            return this.x >= 0
                    && this.x < n
                    && this.y < m
                    && this.y >= 0
                    && !visitied[this.y][this.x];
        }

        public Node left() {
            return new Node(this.x - 1, this.y);
        }

        public Node right() {
            return new Node(this.x + 1, this.y);
        }

        public Node top() {
            return new Node(this.x, this.y + 1);
        }

        public Node bottom() {
            return new Node(this.x, this.y - 1);
        }
    }
}
