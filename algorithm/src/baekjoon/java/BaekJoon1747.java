package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 1000000;
        boolean[] a = new boolean[max * 10 + 1];

        for (int i = 2; i < max * 10 + 1; i++) {
            a[i] = true;
        }

        int result = 0;
        for (int i = 2; i < max * 10 + 1; i++) {
            if (a[i]) {
                for (int j = i + i; j < max * 10 + 1; j = j + i) {
                    a[j] = false;
                }
                if (i >= n) {
                    if (isPalindrome(i)) {
                        result = i;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static boolean isPalindrome(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
