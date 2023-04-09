package baekjoon.java.boj;

import java.io.*;

public class BOJ10597 {

    private static String s;
    private static int n;
    private static int len;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        len = s.length();
        if (len <= 9) n = len;
        else n = 9 + (len - 9) / 2;

        visited = new boolean[n + 1];

        dfs(0, "");
    }

    private static void dfs(int startIdx, String answer) {
        if (startIdx == len) {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) return;
            }
            System.out.println(answer.trim());
            System.exit(0);
            return;
        }

        int num = Integer.parseInt(s.substring(startIdx, startIdx + 1));
        if (!visited[num]) {
            visited[num] = true;
            dfs(startIdx + 1, answer + " " + num);
            visited[num] = false;
        }

        if (startIdx < len - 1) {
            num = Integer.parseInt(s.substring(startIdx, startIdx + 2));
            if (num <= n && !visited[num]) {
                visited[num] = true;
                dfs(startIdx + 2, answer + " " + num);
                visited[num] = false;
            }
        }
    }
}
