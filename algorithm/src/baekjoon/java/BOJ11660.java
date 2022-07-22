package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 표의 크기 n
        int n = Integer.parseInt(st.nextToken());
        // 합을 구해야 하는 횟수 m
        int m = Integer.parseInt(st.nextToken());

        // 구간합 배열
        int[][] s = new int[n+1][n+1];

        // s에 구간합 입력
        for (int i = 1; i < s.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < s[i].length; j++) {
                s[i][j] = s[i][j-1] + s[i-1][j] - s[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];

            bw.write(result + "\n");
        }
        bw.flush();
    }
}
