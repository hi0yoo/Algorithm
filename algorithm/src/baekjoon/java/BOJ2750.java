package baekjoon.java;

import java.io.*;

public class BOJ2750 {

    private static void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j + 1);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(a[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
