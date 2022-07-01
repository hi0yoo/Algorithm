package baekjoon.java;

import java.io.*;
import java.util.Stack;

public class BaekJoon1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int count = 1;
        int index = 0;
        boolean result = true;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() || count <= a[i]) {
                stack.push(count++);
                sb.append("+\n");
            }
            int peekNum = stack.peek();
            if (peekNum == a[i]) {
                stack.pop();
                sb.append("-\n");
            } else if (peekNum > a[i]) {
                result = false;
                System.out.println("NO");
                break;
            }
        }

        if (result) {
            bw.write(sb.toString());
        }
        bw.flush();

    }
}
