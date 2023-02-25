package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ1107 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) broken[Integer.parseInt(st.nextToken())] = true;
        }

        int answer = Math.abs(n - 100);
        for (int i = 0; i <= 999_999; i++) {
            String s = String.valueOf(i);
            int len = s.length();

            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (broken[s.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) answer = Math.min(Math.abs(n - i) + len, answer);
        }

        System.out.println(answer);
    }
}
