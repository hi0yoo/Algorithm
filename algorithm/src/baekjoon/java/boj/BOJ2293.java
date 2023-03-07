package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ2293 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j <= k - arr[i]; j++) dp[arr[i] + j] += dp[j];
        }
        System.out.println(dp[k]);
    }
}
