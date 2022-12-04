package baekjoon.java.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ1654 {
    private static int k;
    private static int n;
    private static int[] lines;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 개수
        lines = new int[k];
        n = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        long max = 0;
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            lines[i] = a;
            if (max < lines[i]) {
                max = lines[i];
            }
        }

        max++;
        long min = 0;
        while (min < max) {
            long mid = (min + max) / 2;
            int count = cut(mid);
            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static int cut(long length) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += (lines[i] / length);
        }
        return count;
    }
}
