package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO 다시 풀기
public class BaekJoon1167 {

    static int[] a;
    static boolean[] l;
    static ArrayList<Node>[] e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int v = Integer.parseInt(br.readLine());

        e = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            e[i] = new ArrayList<>();
        }

        boolean b = true;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            b = true;
            int n = Integer.parseInt(st.nextToken());
            while (b) {
                int m = Integer.parseInt(st.nextToken());
                if (m == -1) {
                    b = false;
                } else {
                    int k = Integer.parseInt(st.nextToken());
                    e[n].add(new Node(m, k));
                }
            }
        }

        a = new int[v+1];
        l = new boolean[v+1];
        bfs(1);
        int max = 1;
        for (int i = 2; i <= v; i++) {
            if (a[max] < a[i]) {
                max = i;
            }
        }
        l = new boolean[v+1];
        a = new int[v+1];
        bfs(max);
        Arrays.sort(a);
        System.out.println(a[v]);

    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        l[idx] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node node : e[now]) {
                int v1 = node.v1;
                int g = node.g;
                if (!l[v1]) {
                    l[v1] = true;
                    queue.add(v1);
                    a[v1] = a[now] + g;
                }
            }
        }
    }

    static class Node {
        public int v1;
        public int g;

        public Node(int v1, int g) {
            this.v1 = v1;
            this.g = g;
        }
    }
}
