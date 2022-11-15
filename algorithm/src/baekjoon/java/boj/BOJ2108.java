package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            a[i] = num;
        }
        Arrays.sort(a);

        int[] count = new int[n];
        int tmp = 4001;
        for (int i = 0; i < n; i++) {
            if (a[i] != tmp) {
                count[i] = 1;
                tmp = a[i];
            } else {
                count[i] = count[i-1] + 1;
            }
        }

        int max = 0;
        int maxCount = 0;
        int kk = 1;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                maxCount = i;
                kk = 1;
            } else if (max == count[i] && kk < 2) {
                maxCount=i;
                kk++;
            }
        }

        int w = Math.round((float) sum / (float) n);
        int x = a[n/2];
        int y = a[maxCount];
        int z = a[n-1] - a[0];

        sb.append(w).append("\n")
                .append(x).append("\n")
                .append(y).append("\n")
                .append(z).append("\n");
        System.out.println(sb);
    }
}
