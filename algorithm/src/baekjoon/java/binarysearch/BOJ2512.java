package baekjoon.java.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    private static int n;
    private static int[] arr;
    private static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        total = Long.parseLong(br.readLine());

        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            long count = count(mid);
            if (count > total) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static long count(int amount) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(arr[i], amount);
        }
        return result;
    }
}
