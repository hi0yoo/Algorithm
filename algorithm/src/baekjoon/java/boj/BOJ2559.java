package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += a[i];
        }

        int tmp = max;
        int p = 0;
        int q = k;
        while (q < n) {
            tmp += a[q++];
            tmp -= a[p++];
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }
}
