package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO 다시 풀기
public class BOJ1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long start = 1;
        long end = k;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
