package baekjoon.java.shortest;

import java.util.*;
import java.io.*;

// 플로이드 워셜
public class BOJ1389 {
    private static final int INF = 999999;
    private static int n;
    private static int m;
    private static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        // 최단거리 테이블 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = INF;
                }
            }
        }

        // 경로 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        // 플로이드 워셜 수행
        for (int K = 1; K <= n; K++) { // 경유 노드 K
            for (int A = 1; A <= n; A++) { // 출발 노드 A
                for (int B = 1; B <= n; B++) { // 목적지 노드 B
                    // 경유 노드를 거쳐가는 경우가 더 적은 비용이 든다면 최단거리 테이블 갱신
                    arr[A][B] = Math.min(arr[A][B], arr[A][K] + arr[K][B]);
                }
            }
        }

        int minNum = INF;
        int minUser = 0;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += arr[i][j];
            }

            if (minNum > total) {
                minNum = total;
                minUser = i;
            }
        }

        System.out.println(minUser);
    }
}
