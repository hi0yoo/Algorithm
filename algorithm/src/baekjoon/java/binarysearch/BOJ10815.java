package baekjoon.java.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10815 {
    private static int[] arr;
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int v = binarySearch(target, 0, n - 1);
            sb.append(v);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int target, int start, int end) {
        int mid = (start + end) / 2;
        if (target == arr[mid]) {
            return 1;
        }
        if (start >= end) {
            return 0;
        }

        if (target < arr[mid]) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }
}
