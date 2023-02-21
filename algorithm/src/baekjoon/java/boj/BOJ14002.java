package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ14002 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
                if (dp[i] > max) max = dp[i];
            }
        }
        Stack<Integer> stack = new Stack<>();
        int k = max;
        for (int i = n; i > 0; i--) {
            if (dp[i] == k) {
                stack.push(arr[i]);
                k--;
            }
            if (k == 0) break;
        }
        sb.append(max + "\n");
        for (int i = 1; i <= max; i++) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
