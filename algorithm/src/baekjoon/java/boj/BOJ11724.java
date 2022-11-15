package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// TODO 다시 풀기
public class BOJ11724 {

    private static int result = 0;
    private static ArrayList<Integer>[] a;
    private static boolean[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new ArrayList[n+1];
        b = new boolean[n+1];
        for (int k = 1; k < n+1; k++) {
            a[k] = new ArrayList<>();
        }
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a[u].add(v);
            a[v].add(u);
        }

        for (int k = 1; k < n+1; k++) {
            if (!b[k]) {
                result++;
                fun(k);
            }
        }
        System.out.println(result);
    }

    public static void fun(int v) {
        if (b[v]) {
            return;
        }
        b[v] = true;
        for (int i : a[v]) {
            if (!b[i]) {
                fun(i);
            }
        }
    }
}
