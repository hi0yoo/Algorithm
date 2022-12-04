package baekjoon.java.shortest;

import java.util.*;
import java.io.*;

public class BOJ2458 {
    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            arr[i][i] = true;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        // 플로이드 워셜
        // i,k 비교값과 k,j 비교값을 모두 알 수 있으면 i,j의 비굣값을 알 수 있음.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                // arr[i][j] = true 는 i가 j보다 작다는 의미이다.
                if (!arr[i][j] && !arr[j][i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
