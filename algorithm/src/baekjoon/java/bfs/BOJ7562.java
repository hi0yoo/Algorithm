package baekjoon.java.bfs;

import java.io.*;
import java.util.*;

public class BOJ7562 {
    private static StringTokenizer st;
    private static boolean[][] visited;
    private static int l;
    private static int currentX;
    private static int currentY;
    private static int goalX;
    private static int goalY;
    private static int count;

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            currentX = Integer.parseInt(st.nextToken());
            currentY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());
            count = 0;

            bfs();
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue.add(new Node(currentX, currentY));
        visited[currentY][currentX] = true;

        while (currentX != goalX || currentY != goalY) {
            count++;
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (poll.getX() == goalX && poll.getY() == goalY) {
                    currentX = poll.getX();
                    currentY = poll.getY();
                    if (count > 0) {
                        count--;
                    }
                    break;
                }
                queue2.add(poll);
            }
            while (!queue2.isEmpty()) {
                Node poll = queue2.poll();
                int x = poll.getX();
                int y = poll.getY();
                if (x-2 >= 0 && y-1 >= 0 && !visited[y-1][x-2]) {
                    int tmpX = x-2;
                    int tmpY = y-1;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x-1 >= 0 && y-2 >= 0 && !visited[y-2][x-1]) {
                    int tmpX = x-1;
                    int tmpY = y-2;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x+2 < l && y-1 >= 0 && !visited[y-1][x+2]) {
                    int tmpX = x+2;
                    int tmpY = y-1;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x+1 < l && y-2 >= 0 && !visited[y-2][x+1]) {
                    int tmpX = x+1;
                    int tmpY = y-2;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x+2 < l && y+1 < l && !visited[y+1][x+2]) {
                    int tmpX = x+2;
                    int tmpY = y+1;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x+1 < l && y+2 < l && !visited[y+2][x+1]) {
                    int tmpX = x+1;
                    int tmpY = y+2;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x-2 >= 0 && y+1 < l && !visited[y+1][x-2]) {
                    int tmpX = x-2;
                    int tmpY = y+1;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
                if (x-1 >= 0 && y+2 < l && !visited[y+2][x-1]) {
                    int tmpX = x-1;
                    int tmpY = y+2;
                    queue.add(new Node(tmpX, tmpY));
                    visited[tmpY][tmpX] = true;
                }
            }
        }
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
