package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ2467 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int abs = Math.abs(arr[i] + arr[mid]);

                if (abs < min) {
                    min = abs;
                    a = i;
                    b = mid;
                }

                if (arr[mid] >= -arr[i]) right = mid - 1;
                else left = mid + 1;
            }
        }
        System.out.println(arr[a] + " " + arr[b]);
    }
}
