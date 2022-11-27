package study.dbna.shortest;

import java.io.*;
import java.util.*;

/**
 * 최단 경로 연습 문제 - 플로이드 워셜 알고리즘
 */
public class FutureCity {

    public static void main(String[] args) throws IOException {
        /*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

4 2
1 3
2 4
3 4
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n = 회사의 개수, m = 경로의 개수
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 999;
                }
            }
        }
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            arr[a1][a2] = 1;
            arr[a2][a1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        // 각 노드간 거리 = 1
        // x = 최종 목적지, k = 경유 목적지
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n+1; i++) { // 현재 노드
            for (int j = 1; j < n+1; j++) { // 목적지 노드
                for (int l = 1; l < n+1; l++) { // 중간 노드
                    if (i != j && i != l) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][l] + arr[l][j]);
                    }
                }
            }
        }

        if (arr[1][k] == 999 || arr[k][x] == 999) {
            System.out.println(-1);
        } else {
            System.out.println(arr[1][k] + arr[k][x]);
        }
    }
}
