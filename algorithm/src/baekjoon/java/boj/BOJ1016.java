package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int) (max - min + 1);
        boolean[] a = new boolean[size];
        Arrays.fill(a, true);

        int result = size;

        for (long i = 2; i * i <= max; i++) {
            long p = i * i;
            long start = min / p;
            if (min % p != 0) {
                start++;
            }
            for (long j = start; j * p <= max; j++) {
                int k = (int) ((j * p) - min);
                if (a[k]) {
                    a[k] = false;
                    result--;
                }
            }
        }

        System.out.println(result);
    }
}
