package baekjoon.java.boj;

import java.io.*;

public class BOJ9251 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int s1len = s1.length();
        int s2len = s2.length();
        int[][] dp = new int[s1len + 1][s2len + 1];
        for (int i = 1; i <= s1len; i++) {
            for (int j = 1; j <= s2len; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[s1len][s2len]);
    }
}
