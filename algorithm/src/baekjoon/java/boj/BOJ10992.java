package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        int length = 2 * n - 1;
        int mid = length / 2 + 1;
        int p = mid;
        int q = mid;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= length; j++) {
                if (j == p || j == q) {
                    sb.append("*");
                    if (j == q) break;
                } else {
                    sb.append(" ");
                }
            }
            p--; q++;
            sb.append("\n");
        }
        for (int i = 0; i < length; i++) {
            sb.append("*");
        }
        System.out.println(sb);
    }
}
