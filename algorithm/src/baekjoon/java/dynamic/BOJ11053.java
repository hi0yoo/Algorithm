package baekjoon.java.dynamic;

import java.io.*;
import java.util.*;

public class BOJ11053 {
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            int tmpIdx = idx;
            while (tmpIdx > 0 && arr[i] <= dp[tmpIdx]) tmpIdx--;
            if (dp[tmpIdx + 1] > arr[i]) dp[tmpIdx + 1] = arr[i];
            if (tmpIdx == idx) dp[++idx] = arr[i];
        }
        System.out.println(idx);
    }
}
