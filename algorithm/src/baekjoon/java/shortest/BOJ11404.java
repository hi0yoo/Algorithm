package baekjoon.java.shortest;

import java.util.*;
import java.io.*;

// 플로이드 워셜
public class BOJ11404 {
    private static final int INF = 99999999;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (arr[a][b] == 0 || (arr[a][b] != 0 && c < arr[a][b])) {
                arr[a][b] = c;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && k != j && k != i) {
                        int x = arr[i][j] == 0 ? INF : arr[i][j];
                        int y = arr[i][k] == 0 ? INF : arr[i][k];
                        int z = arr[k][j] == 0 ? INF : arr[k][j];
                        arr[i][j] = Math.min(x, y + z);
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = arr[i][j] == INF ? 0 : arr[i][j];
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
