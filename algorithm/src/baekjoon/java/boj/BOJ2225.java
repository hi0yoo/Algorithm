package baekjoon.java.boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2225 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }

        for (int j = 0; j <= n; j++) dp[1][j] = 1;

        // i: k, j: n
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                long sum = 0;
                for (int a = 0; a <= j; a++) {
                    sum += dp[i - 1][a];
                }
                dp[i][j] = (sum % 1_000_000_000);
            }
        }

        System.out.println(dp[k][n]);
    }
}
