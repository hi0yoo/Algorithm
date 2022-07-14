package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 최소값
        int n = Integer.parseInt(st.nextToken()); // 최대값

        boolean[] a = new boolean[n + 1];
        for (int i = 2; i < n+1; i++) {
            a[i] = true;
        }

        for (int i = 2; i < n+1; i++) {
            if (a[i]) {
                for (int j = 2; j <= n/i; j++) {
                    if (a[i*j]) {
                        a[i*j] = false;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = m; i < n+1; i++) {
            if (a[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
