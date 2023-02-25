package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ14889 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = 0;
        while (Integer.bitCount(k) < n) k++;

        int answer = 2000;
        while (k > 0) {
            boolean[] start = new boolean[n + 1];
            boolean[] link = new boolean[n + 1];

            if (Integer.bitCount(k) == n/2) {
                for (int i = 1; i <= n; i++) {
                    if ((k & (1 << (n - i))) > 0) {
                        start[i] = true;
                    } else {
                        link[i] = true;
                    }
                }

                int startScore = 0;
                for (int i = 1; i < n; i++) {
                    for (int j = i+1; j <= n; j++) {
                        if (start[i] && start[j]) startScore += (arr[i][j] + arr[j][i]);
                    }
                }

                int linkScore = 0;
                for (int i = 1; i < n; i++) {
                    for (int j = i+1; j <= n; j++) {
                        if (link[i] && link[j]) linkScore += (arr[i][j] + arr[j][i]);
                    }
                }

                int abs = Math.abs(startScore - linkScore);
                answer = Math.min(answer, abs);
            }
            k--;
        }

        System.out.println(answer);
    }
}
