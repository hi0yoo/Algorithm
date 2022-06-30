package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sl = Integer.parseInt(st.nextToken());
        int pl = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] a = new int[4];
        int[] b = new int[4];
        int startIndex = 0;
        int endIndex = pl - 1;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = startIndex; i <= endIndex; i++) {
            Add(s.charAt(i), b);
        }

        if (a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2] && a[3] <= b[3]) {
            count++;
        }

        while (endIndex < sl-1) {
            Delete(s.charAt(startIndex++), b);
            Add(s.charAt(++endIndex), b);

            if (a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2] && a[3] <= b[3]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void Add(char c, int[] b) {
        if (c == 'A') {
            b[0]++;
        } else if (c == 'C') {
            b[1]++;
        } else if (c == 'G') {
            b[2]++;
        } else if (c == 'T') {
            b[3]++;
        }
    }
    private static void Delete(char c, int[] b) {
        if (c == 'A') {
            b[0]--;
        } else if (c == 'C') {
            b[1]--;
        } else if (c == 'G') {
            b[2]--;
        } else if (c == 'T') {
            b[3]--;
        }
    }
}
