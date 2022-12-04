package baekjoon.java.binarysearch;

import java.util.*;
import java.io.*;

public class BOJ2805 {
    private static int n;
    private static int m;
    private static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n, m 입력받기. n : 나무의 수, m : 필요한 나무 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tree = new long[n];
        m = Integer.parseInt(st.nextToken());

        // 나무들의 길이 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            tree[i] = a;
        }
        Arrays.sort(tree);

        long min = 0;
        long max = tree[n-1];
        while (min < max) {
            long mid = (min + max) / 2;
            long sum = cutSum(mid);

            if (m > sum) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    // 전체 나무 자른 뒤 남은 길이 합
    private static long cutSum(long h) {
        long sum = 0;
        for (int i = n-1; i >= 0; i--) {
            // 정렬된 tree 배열이기 때문에 tree[i]가 높이 h보다 작으면 그 이전 나무들은 모두 h보다 작거나 같다.
            // 계산하지 않아도 됨. 반복문 종료.
            long afterCut = tree[i] - h;
            if (afterCut <= 0) {
                break;
            }
            sum += afterCut;
        }
        return sum;
    }
}
