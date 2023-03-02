package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ12015 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[1_000_001];
        int maxIdx = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > arr[maxIdx]) arr[++maxIdx] = a[i];
            else {
                int left = 1;
                int right = maxIdx;
                int mid = 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (a[i] < arr[mid]) right = mid - 1;
                    else if (a[i] > arr[mid]) left = mid + 1;
                    else break;
                }
                if (a[i] > arr[mid]) arr[++mid] = a[i];
                else arr[mid] = a[i];

                if (mid > maxIdx) maxIdx = mid;
            }
        }
        System.out.println(maxIdx);
    }
}
