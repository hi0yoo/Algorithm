package study.dbna.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BigNumber {

    public static void main(String[] args) throws IOException {
        /*
            첫째줄에 N(2 <= N <= 1000), M(1 <= M <= 10000), N(1 <= N <= 10000)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int a = arr[0];
        int b = arr[1];

        long sum = (m / (k + 1)) * (a * k + b) + ((m % (k + 1)) * a);

        // n5 m8 k3
//        long sum = 0;
//        int count = 0;
//        int pointer = 0;
//        for (int i = 0; i < m; i++) {
//            if (count < k) {
//                sum += arr[pointer];
//                count++;
//            } else {
//                sum += arr[pointer+1];
//                count = 0;
//            }
//        }

        System.out.println(sum);
    }
}
