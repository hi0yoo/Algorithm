package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        // -부터 -까지 합한다.
        int sum = 0;
        int i = 0;
        while (st.hasMoreTokens()) {
            StringTokenizer stTmp = new StringTokenizer(st.nextToken(), "+");
            if (i == 0) {
                while (stTmp.hasMoreTokens()) {
                    sum += Integer.parseInt(stTmp.nextToken());
                    i++;
                }
            } else {
                int tmpSum = 0;
                while (stTmp.hasMoreTokens()) {
                    tmpSum += Integer.parseInt(stTmp.nextToken());
                }
                sum -= tmpSum;
            }
        }

        System.out.println(sum);
    }
}
