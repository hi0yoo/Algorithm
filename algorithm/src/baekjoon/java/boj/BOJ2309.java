package baekjoon.java.boj;

import java.io.*;
import java.util.Arrays;

public class BOJ2309 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int[] arr2 = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int result = sum - arr[i] - arr[j];
                if (result == 100) {
                    arr2[0] = i;
                    arr2[1] = j;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            if (i != arr2[0] && i != arr2[1]) {
                sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
