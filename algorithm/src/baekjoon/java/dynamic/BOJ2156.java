package baekjoon.java.dynamic;

import java.io.*;

public class BOJ2156 {
    private static int[] wines;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wines = new int[n + 1];
        for (int i = 1; i <= n; i++) wines[i] = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = wines[1];
        if (n >= 2) dp[2] = wines[1] + wines[2];
        for (int i = 3; i <= n; i++) dp[i] = tripleMax(dp[i - 1], dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]);

        System.out.println(dp[n]);
    }

    private static int tripleMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
