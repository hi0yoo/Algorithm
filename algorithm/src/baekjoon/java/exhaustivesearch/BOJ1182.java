package baekjoon.java.exhaustivesearch;

import java.io.*;
import java.util.*;

public class BOJ1182 {
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 1 << n; i++) {
            int sum = 0;
            if (Integer.bitCount(i) > 0) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        sum += arr[j];
                    }
                }
                if (sum == s) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
