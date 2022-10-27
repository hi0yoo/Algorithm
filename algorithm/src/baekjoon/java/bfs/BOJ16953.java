package baekjoon.java.bfs;

import java.io.*;
import java.util.*;

public class BOJ16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int count = 0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);
        Set<Long> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Long poll = queue.poll();
                if (poll == b) {
                    System.out.println(count + 1);
                    return;
                }
                long mul = poll * 2;
                if (mul <= b && !set.contains(mul)) {
                    queue.add(mul);
                    set.add(mul);
                }
                long addOne = poll * 10 + 1;
                if (addOne <= b && !set.contains(addOne)) {
                    queue.add(addOne);
                    set.add(addOne);
                }
            }
            count++;
        }
        System.out.println(-1);

        // greedy
//        long a = Long.parseLong(st.nextToken());
//        long b = Long.parseLong(st.nextToken());
//
//        int count = 0;
//        while (b != a) {
//            if (b < a) {
//                count = -1;
//                break;
//            }
//            if (b % 10 != 1 && b % 2 != 0) {
//                count = -1;
//                break;
//            }
//
//            if (b % 2 == 0) {
//                b = b/2;
//            } else {
//                b = b/10;
//            }
//            count++;
//        }
//        System.out.println(count == -1 ? count : count+1);
    }
}
