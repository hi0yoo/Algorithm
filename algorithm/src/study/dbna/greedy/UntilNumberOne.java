package study.dbna.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UntilNumberOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int num = n;
        int count = 0;
        while (num > 1) {
            if (num % k != 0) {
                num -= 1;
            } else {
                num = num / k;
            }
            count++;
        }

        System.out.println(count);
    }
}
