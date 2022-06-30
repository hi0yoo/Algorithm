package baekjoon.java;

import java.io.*;

public class BaekJoon2018 {

    public static void main(String[] args) throws IOException {
        // n 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;

        while (endIndex != n) {
            if (sum == n) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if (sum > n) {
                sum -= startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }

        bw.write("" + count);
        bw.flush();
    }
}
