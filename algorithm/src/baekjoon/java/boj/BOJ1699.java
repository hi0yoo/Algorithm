package baekjoon.java.boj;

import java.io.*;

public class BOJ1699 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = 999999;
            int sqrt = (int) Math.sqrt(i);
            for (int j = sqrt; j > 0; j--) {
                min = Math.min(min, dp[i - (j * j)] + 1);
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
