package baekjoon.java.boj;

import java.io.*;

public class BOJ17103 {

    private static final int MAX_NUM = 1_000_000;

    public static void main(String[] args) throws Exception {
        // true: 소수 X, false: 소수
        boolean[] b = new boolean[MAX_NUM + 1];
        for (int i = 2; i <= MAX_NUM; i++) {
            int k = i * 2;
            while (k <= MAX_NUM) {
                b[k] = true;
                k += i;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= n / 2; j++) {
                if (!b[j]) {
                    if (!b[n - j]) count++;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
