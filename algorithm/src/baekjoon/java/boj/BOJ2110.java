package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ2110 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 집의 개수
        int n = Integer.parseInt(st.nextToken());
        // 집의 좌표 배열
        int[] x = new int[n];
        // 공유기 개수
        int c = Integer.parseInt(st.nextToken());
        // 집 좌표 초기화
        for (int i = 0; i < n; i++) x[i] = Integer.parseInt(br.readLine());
        Arrays.sort(x);

        int left = 1; // 최소 거리
        int right = x[n - 1] - x[0] + 1; // 최대 거리
        while (left < right) {
            int mid = (left + right) / 2; // 탐색 거리
            int last = 0;
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (x[i] >= x[last] + mid) {
                    last = i;
                    count++;
                }
            }
            if (count >= c) left = mid + 1;
            else right = mid;
        }
        System.out.println(left - 1);
    }
}
