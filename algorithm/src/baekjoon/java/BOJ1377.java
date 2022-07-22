package baekjoon.java;

import java.io.*;
import java.util.Arrays;

public class BOJ1377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        OrigArray[] a = new OrigArray[n];
        for (int i = 0; i < n; i++) {
            a[i] = new OrigArray(Integer.parseInt(br.readLine()));
        }

        Arrays.sort(a, (o1, o2) -> o1.value - o2.value);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].index - i > result) {
                result = a[i].index - i;
            }
        }

        sb.append((result + 1) + "\n");

        bw.write(sb.toString());
        bw.flush();
    }

    static class OrigArray {
        private static int IDX = 0;

        private int index;
        private int value;

        public OrigArray(int value) {
            this.index = IDX++;
            this.value = value;
        }
    }
}
