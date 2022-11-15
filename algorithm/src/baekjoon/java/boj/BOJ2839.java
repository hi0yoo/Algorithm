package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int k = n / 5;

        int i = k;
        int j = (n - (i * 5)) / 3;
        int count = 0;
        while(true) {
            if (i * 5 + j * 3 == n && i >= 0) {
                count = i + j;
                break;
            }
            if (i < 0) {
                count = -1;
                break;
            }
            i--;
            j = (n - (i * 5)) / 3;
        }

        System.out.println(count);
    }
}
