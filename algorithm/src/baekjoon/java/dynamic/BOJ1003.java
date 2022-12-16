package baekjoon.java.dynamic;

import java.io.*;

public class BOJ1003 {
    private static StringBuffer sb = new StringBuffer();
    private static int[][] dp = new int[41][2];
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] nArray = new int[t]; // 각 테스트 케이스 N 배열
        for (int i = 0; i < t; i++) {
            nArray[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nArray[i]);
        }

        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int i=0; i < t; i++) {
            int n = nArray[i]; // 각 테스트의 N

            writeResult(n);
        }

        System.out.println(sb);
    }

    // 각 테스트마다 결과 입력
    private static void writeResult(int n) {
        sb.append(dp[n][0] + " " + dp[n][1]);
        sb.append("\n");
    }
}
