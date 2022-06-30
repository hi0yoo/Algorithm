package baekjoon.java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int leftIndex = 0;
            int rightIndex = n-1;
            while (leftIndex < rightIndex) {
                if (a[leftIndex] + a[rightIndex] > a[i]) {
                    rightIndex--;
                } else if (a[leftIndex] + a[rightIndex] < a[i]) {
                    leftIndex++;
                } else {
                    if (leftIndex != i && rightIndex != i) {
                        count++;
                        break;
                    } else if (leftIndex == i) {
                        leftIndex++;
                    } else if (rightIndex == i) {
                        rightIndex--;
                    }
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
