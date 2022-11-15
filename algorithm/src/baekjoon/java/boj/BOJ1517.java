package baekjoon.java.boj;

import java.io.*;
import java.util.StringTokenizer;

// TODO Retry
public class BOJ1517 {

    private static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(a, t, 0, n-1);

        System.out.println(result);
    }

    private static void mergeSort(int[] a, int[] t, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int m = start + (end - start) / 2;
        mergeSort(a, t, start, m);
        mergeSort(a, t, m+1, end);
        for (int i = start; i <= end; i++) {
            t[i] = a[i];
        }
        int k = start;
        int idx1 = start;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= end) {
            if (t[idx1] > t[idx2]) {
                a[k] = t[idx2];
                result = result + idx2 - k;
                k++;
                idx2++;
            } else {
                a[k] = t[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= m) {
            a[k] = t[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            a[k] = t[idx2];
            k++;
            idx2++;
        }
    }
}
