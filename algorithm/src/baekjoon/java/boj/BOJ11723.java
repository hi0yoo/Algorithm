package baekjoon.java.boj;

import java.io.*;

public class BOJ11723 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "add":
                    int x = Integer.parseInt(str[1]);
                    s = s | (1 << (21 - x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(str[1]);
                    s = s & ~(1 << (21 - x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(str[1]);
                    if ((s & (1 << (21 - x - 1))) > 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(str[1]);
                    if ((s & (1 << (21 - x - 1))) == 0) s = s | (1 << (21 - x - 1));
                    else s = s & ~(1 << (21 - x - 1));
                    break;
                case "all":
                    while (Integer.bitCount(s) < 20) s++;
                    break;
                default:
                    s = 0;
            }
        }
        System.out.println(sb);
    }
}
