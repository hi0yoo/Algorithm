package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 배열 a의 요소 a[i]는 가로의 길이가 i일 때, 타일 조합 방법의 수를 말한다.
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                a[i] = i; // i <= 2 일 때, 경우의 수는 i개
            } else {
                // 가로 길이가 i 일 때, 경우의 수는 (n-1 의 방법 수) + (n-2 의 방법의 수)
                a[i] = (a[i - 1] + a[i - 2]) % 10007;
            }
        }
        System.out.println(a[n]);
    }
}
