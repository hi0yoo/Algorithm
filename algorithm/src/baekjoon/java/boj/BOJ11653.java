package baekjoon.java.boj;

import java.io.*;

public class BOJ11653 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n > 1) {
            for (int i = 2; i <= 10_000_000; i++) {
                if (n % i == 0) {
                    bw.write(i + "\n");
                    n /= i;
                    break;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
