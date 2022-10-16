package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5585 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        int count = 0;
        count += n / 500;
        n = n % 500;

        count += n / 100;
        n = n % 100;

        count += n / 50;
        n = n % 50;

        count += n / 10;
        n = n % 10;

        count += n / 5;
        n = n % 5;

        count += n;

        System.out.println(count);
    }
}
