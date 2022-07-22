package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 비상연락망
// TODO 다시 풀기
public class BOJ2649 {

    static int n;
    static ArrayList<Integer>[] arr;
    static boolean[] booleans;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = null;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int man = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                arr[man].add(Integer.parseInt(st.nextToken()));
            }
        }

        booleans = new boolean[n+1];
        booleans[0] = true;
        dfs(1, 1);
    }

    static void dfs(int start, int count) {

    }
}
