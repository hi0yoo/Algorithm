package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1931 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시간을 기준으로 정렬
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        // 가장 빨리 끝나는 것 선택 : idx=0
        int currentIdx = 0;
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= arr[currentIdx][1]) {
                currentIdx = i;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
