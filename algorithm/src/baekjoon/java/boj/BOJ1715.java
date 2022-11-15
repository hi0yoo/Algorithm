package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        // 카드가 한묶음 밖에 없으면 합칠 필요가 없다.
        // n == 1 일때, 0이 나오는게 맞다.
        while (queue.size() != 1) {
            long p1 = queue.remove();
            long p2 = queue.remove();
            long tmp = p1 + p2;
            sum += tmp;
            queue.add(tmp);
        }
        System.out.println(sum);
    }
}
