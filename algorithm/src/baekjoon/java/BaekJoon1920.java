package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1920 {

    static int[] a;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            binaryFind(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    private static void binaryFind(int num) {
        int start = 0;
        int end = a.length - 1;
        if (a[end] < num) {
            sb.append("0\n");
            return;
        }
        while (start <= end) {
            int mid = (end + start) / 2;
            int val = a[mid];
            if (val > num) {
                end = mid - 1;
            } else if (val < num) {
                start = mid + 1;
            } else {
                sb.append("1\n");
                return;
            }
        }
        sb.append("0\n");
    }
}
