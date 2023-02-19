package baekjoon.java.boj;

import java.io.*;
import java.util.*;

public class BOJ11052 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) for (int j = i; j > 0; j--) arr[i] = Math.max(arr[j] + arr[i - j], arr[i]);
        System.out.println(arr[n]);
    }
}
