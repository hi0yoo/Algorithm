package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        Arrays.sort(s, (o1, o2) -> {
            int i = o1.length();
            int j = o2.length();
            int result = 0;
            if (i == j) {
                char[] o1Chars = o1.toCharArray();
                char[] o2Chars = o2.toCharArray();
                for (int k = 0; k < i; k++) {
                    if (o1Chars[k] != o2Chars[k]) {
                        result = o1Chars[k] - o2Chars[k];
                        break;
                    }
                }
            } else if (i > j) {
                result = 1;
            } else {
                result = -1;
            }
            return result;
        });

        System.out.println(s[0]);
        if (s.length > 1) {
            for (int i = 1; i < n; i++) {
                if (!s[i-1].equals(s[i])) {
                    System.out.println(s[i]);
                }
            }
        }
    }
}
