package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long lower = a <= b ? a : b;
        long higher = a > b ? a : b;
        long result = lower;

        while (higher % lower != 0) {
            result = higher % lower;
            higher = lower;
            lower = result;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }
}
