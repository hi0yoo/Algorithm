package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {

    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dfs(2, n, 1);
        dfs(3, n, 1);
        dfs(5, n, 1);
        dfs(7, n, 1);

        System.out.println(sb);
    }

    private static void dfs(int num, int n, int k) {
        if (k == n) {
            if (isPrime(num)) {
                sb.append(num + "\n");
            }
            return;
        }

        for (int i = 1; i < 10; i+=2) {
            int kk = (num*10)+i;
            if (isPrime(kk)) {
                dfs(kk, n, k+1);
            }
        }

    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
