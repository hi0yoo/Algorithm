package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] r;
    private static int n;
    private static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Integer k1 = Integer.parseInt(st.nextToken());
            Integer k2 = Integer.parseInt(st.nextToken());
            arr[k1].add(k2);
            arr[k2].add(k1);
        }
        r = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!result) {
                dfs(i, 1);
            } else {
                break;
            }
        }
        System.out.println(result ? 1 : 0);
    }

    public static void dfs(int num, int depth) {
        if (depth >= 5) {
            result = true;
            return;
        }
        r[num] = true;
        for (int i = 0; i < arr[num].size(); i++) {
            int next = arr[num].get(i);
            if (!r[next]) {
                dfs(next, depth + 1);
            }
        }
        r[num] = false;
    }


}
