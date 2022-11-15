package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] chars = br.readLine().toCharArray();
        int[][] count = new int[chars.length + 1][26];
        for (int i = 1; i <= chars.length; i++) {
            int c = chars[i-1] - 97;
            for (int j = 0; j < 26; j++) {
                if (j == c) {
                    count[i][j] = count[i-1][j] + 1;
                } else {
                    count[i][j] = count[i-1][j];
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append((count[r+1][c-97] - count[l][c-97]) + "\n");
        }
        System.out.println(sb);
    }
}
