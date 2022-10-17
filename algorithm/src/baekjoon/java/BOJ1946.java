package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1946 {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                nums[j][0] = Integer.parseInt(st.nextToken());
                nums[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));

            int min = nums[0][1];
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (nums[j][1] < min) {
                    count++;
                    min = nums[j][1];
                }
            }
            sb.append(count);
            if (i < t - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
