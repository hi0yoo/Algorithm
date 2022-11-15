package baekjoon.java.boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] s = br.readLine().split("");
        Arrays.sort(s, Collections.reverseOrder());
        Arrays.stream(s).forEach(sb::append);
        System.out.println(sb);
    }
}
