package baekjoon.java.shortest;

import java.util.*;
import java.io.*;

public class BOJ11403 {
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점 개수
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        // 인접 노드 정보 입력
        for (int i = 0; i < n; i++) { // i번째 노드의 인접 노드
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) != 0) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    // a = b = 0 일때,
                    if (arr[a][k] + arr[k][b] > 1) {
                        arr[a][b] = 1;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                sb.append(arr[a][b] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
