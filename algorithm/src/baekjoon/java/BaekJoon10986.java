package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

// TODO int & long에 대해 공부
public class BaekJoon10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long result = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] s = new long[n];
        long[] k = new long[m];
        s[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < s.length; i++) {
            s[i] = s[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < s.length; i++) {
            int remainder = (int) (s[i] % m);
            if (remainder == 0) result++;
            k[remainder]++;
        }

        for (int i = 0; i < k.length; i++) {
            if (k[i] > 1)
                result += (k[i] * (k[i] - 1) / 2);
        }

        bw.write(""+result);
        bw.flush();
    }
}
