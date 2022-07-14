package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = 10000001;
        boolean[] booleans = new boolean[max];

        for (int i = 2; i < max; i++) {
            booleans[i] = true;
        }
        // 10,000,000의 제곱근까지 수행하는 이유?
        for (int i = 2; i < Math.sqrt(max); i++) {
            if (booleans[i]) {
                for (int j = i + i; j < max; j=j+i) {
                    if (booleans[j]) {
                        booleans[j] = false;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 2; i < max; i++) {
            if (booleans[i]) {
                long tmp = i;
                // 그냥 제곱하면 long 범위 초과.
                // n^k <= b => n <= b/n^k-1
                while ((double)i <= (double)b/(double)tmp) {
                    if ((double)i >= (double)a/(double)tmp) {
                        result++;
                    }
                    tmp = tmp * i;
                }
            }
        }
        System.out.println(result);
    }
}
