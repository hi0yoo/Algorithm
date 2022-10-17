package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        w[0] = 0;
        for (int i = 1; i < n; i++) {
            w[i] = w[i-1] + Integer.parseInt(st.nextToken());
        }

        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        long total = 0;
        int lowPrice = c[0];
        int pointer = 1;
        int start = 0;

        while(pointer < n - 1) {
            while (pointer < n - 1 && c[pointer] >= lowPrice) {
                pointer++;
            }
            total = total + (long) (w[pointer] - w[start]) * c[start];
            lowPrice = c[pointer];
            start = pointer;
        }

        System.out.println(total);
    }
}
