package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(lcm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
        }
        System.out.println(sb);
    }

    private static int lcm(int a, int b) {
        int lowNum = a <= b ? a : b;
        int highNum = a > b ? a : b;
        int gcd = gcd(lowNum, highNum);

        return lowNum * (highNum / gcd);
    }

    private static int gcd(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        int lowNum = a <= b ? a : b;
        int highNum = a > b ? a : b;

        int result = lowNum;

        while (highNum % lowNum != 0) {
            result = highNum % lowNum;
            highNum = lowNum;
            lowNum = result;
        }
        return result;
    }
}
