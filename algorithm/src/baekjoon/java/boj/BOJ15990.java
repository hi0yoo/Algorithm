package baekjoon.java.boj;

import java.io.*;

public class BOJ15990 {

    public static void main(String[] args) throws Exception {
        long[][] arr = new long[100_001][4];
        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;
        for (int i = 4; i < 100_001; i++) {
            arr[i][1] = (arr[i - 1][2] + arr[i - 1][3]) % 1_000_000_009;
            arr[i][2] = (arr[i - 2][1] + arr[i - 2][3]) % 1_000_000_009;
            arr[i][3] = (arr[i - 3][1] + arr[i - 3][2]) % 1_000_000_009;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write((arr[n][1] + arr[n][2] + arr[n][3]) % 1_000_000_009 + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
