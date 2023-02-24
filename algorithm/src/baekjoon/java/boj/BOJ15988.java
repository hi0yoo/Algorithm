package baekjoon.java.boj;

import java.io.*;

public class BOJ15988 {

    public static void main(String[] args) throws Exception {
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }
}
