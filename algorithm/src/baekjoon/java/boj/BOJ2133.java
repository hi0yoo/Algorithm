package baekjoon.java.boj;

import java.io.*;

public class BOJ2133 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if (n >= 2) dp[2] = 3;
        if (n >= 4) dp[4] = 11;
        int tmp = 0;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2 + (tmp += dp[i - 4] * 2);
        }
        System.out.println(dp[n]);
    }
}
