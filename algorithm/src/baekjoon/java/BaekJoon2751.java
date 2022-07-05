package baekjoon.java;

import java.io.*;
import java.util.Arrays;

public class BaekJoon2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(a[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
