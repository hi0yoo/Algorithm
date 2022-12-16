package baekjoon.java.dynamic;

import java.io.*;
import java.util.*;

public class BOJ10844 {
    // int[x][y] -> x = 자릿수, y = x 자릿수의 자릿값, [x][y] = x 자리의 값이 y일 때의 가능한 수들의 개수
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100, N은 수의 길이

        dp = new int[N + 1][10];
        for (int i = 1; i < 10; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1];
                else if (j == 9) dp[i][j] = dp[i - 1][8];
                else dp[i][j] = mod(dp[i - 1][j - 1] + dp[i - 1][j + 1]);
            }
        }

        System.out.println(Arrays.stream(dp[N]).reduce(0, (left, right) -> mod(left + right)));
    }

    private static int mod(long num) {
        return (int) (num % 1_000_000_000);
    }
}
