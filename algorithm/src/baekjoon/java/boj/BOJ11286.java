package baekjoon.java.boj;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs_o1 = Math.abs(o1);
            int abs_o2 = Math.abs(o2);
            // 양수 반환 : 첫번째 매개변수가 더 큰값.
            // 음수 반환 : 첫번째 매개변수가 더 작은값.
            // PriorityQueue 는 기본으로 최소값을 기준으로 정렬한다.
            if (abs_o1 == abs_o2) {
                return o1 > o2 ? 1 : -1;
            } else {
                return abs_o1 - abs_o2;
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll()+"\n");
                }
            } else {
                queue.add(num);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
