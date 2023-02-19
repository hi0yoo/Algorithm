package baekjoon.java.boj;

import java.io.*;

public class BOJ9095 {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[11];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < 11; i++) arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) bw.write(arr[Integer.parseInt(br.readLine())] + "\n");
        bw.flush();
    }
}
