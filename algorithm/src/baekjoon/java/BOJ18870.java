package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] a = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(a, (o1, o2) -> o1.value - o2.value);

        int tmp = a[0].value;
        int countNum = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].value != tmp) {
                tmp = a[i].value;
                countNum++;
            }
            a[i].count = countNum;
        }
        Arrays.sort(a, (o1, o2) -> o1.idx - o2.idx);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(a[i].count + " ");
        }
        System.out.println(sb);
    }

    static class Node {
        int idx;
        int value;
        int count;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
            this.count = 0;
        }
    }
}
