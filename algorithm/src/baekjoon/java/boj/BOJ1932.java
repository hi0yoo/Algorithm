package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        int answer = dp[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 < 0) dp[i][j] = dp[i - 1][j] + arr[i][j];
                else if (j > i - 1) dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
