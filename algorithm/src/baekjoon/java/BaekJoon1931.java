package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO 수정
public class BaekJoon1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Meeting[] a = new Meeting[n];
        StringTokenizer st = null;
        int max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            if (max < endTime) {
                max = endTime;
            }
            a[i] = new Meeting(startTime, endTime);
        }

        Arrays.sort(a, (o1, o2) -> {
            int length1 = o1.endTime - o1.startTime;
            int length2 = o2.endTime - o2.startTime;
            if (length1 == length2) {
                return o1.startTime - o2.startTime;
            }
            return length1 - length2;
        });

        int result = 0;
        boolean[] t = new boolean[max];
        for (int i = 0; i < n; i++) {
            boolean q = false;
            int startTime = a[i].startTime;
            int endTime = a[i].endTime;
            if (endTime - startTime == 0 || endTime - startTime == 1) {
                t[startTime] = true;
                t[endTime] = true;
                result++;
            } else {
                for (int j = startTime + 1; j < endTime; j++) {
                    if (t[j]) {
                        break;
                    }
                    if (j == endTime - 1) {
                        q = true;
                        result++;
                    }
                }

                if (q) {
                    for (int j = startTime; j < endTime; j++) {
                        t[j] = true;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static class Meeting {
        public int startTime;
        public int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
