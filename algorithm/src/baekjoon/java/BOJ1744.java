package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int negativeNumberCount = 0; // 0 ~ count - 1
        int positiveNumberCount = 0; // negativeNumberCount + zeroCount ~ n - 1
        int zeroCount = 0; // negativeNumberCount ~ negativeNumberCount + zeroCount - 1
        int sum = 0;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            Integer k = Integer.parseInt(br.readLine());
            if (k > 0) {
                if (k == 1) {
                    sum++;
                } else {
                    positiveNumberCount++;
                }
            } else if (k < 0) {
                negativeNumberCount++;
            } else {
                zeroCount++;
            }
            a[i] = k;
        }

        Arrays.sort(a, (o1, o2) -> {
            int tmp = o1 - o2;
            if (tmp == 0) {
                return Math.abs(o1) - Math.abs(o2);
            }
            return tmp;
        });

        /*
        합이 최대가 되려면
        음수 * 양수 => 곱하지 않는다.
        음수 * 음수 or 양수 * 양수
        절대값이 큰애들 끼리 묶는다.

        1. 음수가 홀수개일때, 0과 음수 중 가장 큰 값을 묶는다.
        2. 양수의 1은 묶지 않는다. <- 양수 1을 묶으면 1을 그냥 없애는 효과.
        3. 양수와 0은 묶지 않는다.
         */

        // index
        // 0 ~ count - 1
        // negativeNumberCount ~ negativeNumberCount + zeroCount - 1
        // negativeNumberCount + zeroCount ~ n - 1
        if (negativeNumberCount % 2 != 0) {
            if (zeroCount != 0) {
                negativeNumberCount--;
            } else {
                sum += a[negativeNumberCount -1];
                negativeNumberCount--;
            }
        }
        for (int i = 0; i < negativeNumberCount/2; i++) {
            sum += a[2 * i] * a[2*i+1]; // 0 .. 0 1 , 1 .. 2 3 , 2 .. 4 5
        }

        for (int i = 0; i < positiveNumberCount/2; i++) {
            sum += a[n-1 - 2*i] * a[n-1 - (2*i+1)];
        }
        if (positiveNumberCount % 2 != 0) {
            sum += a[n - positiveNumberCount];
        }

        System.out.println(sum);
    }
}
