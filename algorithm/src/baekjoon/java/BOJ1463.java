package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];
        a[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = a[i-1] + 1;
            if (i % 3 == 0) {
                min = Math.min(min, a[i/3] + 1);
            }
            if (i % 2 == 0) {
                min = Math.min(min, a[i/2] + 1);
            }
            a[i] = min;
        }
        System.out.println(a[n]);
    }
}
