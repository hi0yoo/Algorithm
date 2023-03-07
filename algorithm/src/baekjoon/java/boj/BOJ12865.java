package baekjoon.java.boj;

import java.io.*;
import java.util.*;

// TODO 다시 풀기
public class BOJ12865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // w
            arr[i][1] = Integer.parseInt(st.nextToken()); // v
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= k; w++) {
                if (arr[i][0] > w) dp[i][w] = dp[i - 1][w];
                else dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - arr[i][0]] + arr[i][1]);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) for (int w = 1; w <= k; w++) answer = Math.max(answer, dp[i][w]);

        System.out.println(answer);
    }
}
