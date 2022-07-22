package baekjoon.java;

import java.io.*;

public class BOJ10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int k = 1; // 자릿수
        while (count < 5) {
            int[] tmp = new int[n];
            int[] b = new int[10];
            for (int i = 0; i < n; i++) {
                b[(a[i]/k) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                b[i] += b[i - 1];
            }
            for (int i = n-1; i >= 0; i--) {
                tmp[(b[(a[i]/k) % 10]--) - 1] = a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i] = tmp[i];
            }
            k*=10;
            count++;
        }
        for (int i = 0; i < n; i++) {
            sb.append(a[i] + "\n");
        }
        System.out.println(sb);
    }
}
