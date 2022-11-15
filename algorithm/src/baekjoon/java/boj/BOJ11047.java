package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (k == 0) {
                break;
            }
            tmp = coins[i];
            if (k / tmp != 0) {
                result+= (k / tmp);
                k = k % tmp;
            }
        }
        System.out.println(result);
    }
}
