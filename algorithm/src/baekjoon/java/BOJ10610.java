package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] nums = new int[10];

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 48;
            nums[num]++;
            sum += num;
        }

        StringBuffer sb = new StringBuffer();
        if (sum % 3 == 0 && nums[0] > 0) {
            for (int i = 9; i >= 0; i--) {
                sb.append(String.valueOf(i).repeat(nums[i]));
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
