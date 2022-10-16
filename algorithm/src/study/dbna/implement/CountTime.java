package study.dbna.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTime {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] t = new int[] {0, 0, 0, 0, 0, 0};
        int n = Integer.parseInt(br.readLine());
//        t[0] = n / 10;
//        t[1] = n % 10;

        int count = 0;
        while (t[0] * 10 + t[1] < n + 1) {
            if (Arrays.stream(t).anyMatch(value -> value == 3)) {
                count++;
            }
            t[5]++;
            if (t[5] >= 10) {
                t[4]++;
                t[5] = 0;
            }
            if (t[4] >= 6) {
                t[3]++;
                t[4] = 0;
            }
            if (t[3] >= 10) {
                t[2]++;
                t[3] = 0;
            }
            if (t[2] >= 6) {
                t[1]++;
                t[2] = 0;
            }
            if (t[1] >= 10) {
                t[0]++;
                t[1] = 0;
            }
        }
        System.out.println(count);
    }
}
