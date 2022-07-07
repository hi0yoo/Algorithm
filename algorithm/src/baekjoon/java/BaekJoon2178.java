package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 미로 받기
        boolean[][] b = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(s[j-1]);
                if (num == 1) {
                    b[i][j] = true;
                }
            }
        }

        // 그래프 초기화
        ArrayList<Integer>[] a = new ArrayList[n * m + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 가로 : 현재값에 길이있고 이전값도 길이 있으면 이어준다.
                if (j > 1 && b[i][j] && b[i][j - 1]) {
                    a[(i - 1) * m + j].add((i - 1) * m + j - 1);
                    a[(i - 1) * m + j - 1].add((i - 1) * m + j);
                }

                // 세로 : 위가 길이있고 나도 길이 있으면 이어준다.
                if (i > 1 && b[i][j] && b[i-1][j]) {
                    a[(i - 1) * m + j].add((i - 2) * m + j);
                    a[(i - 2) * m + j].add((i - 1) * m + j);
                }
            }
        }

        int[] check = new int[n * m + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = 1;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < a[poll].size(); i++) {
                int num = a[poll].get(i);
                if (check[num] == 0) {
                    queue.add(num);
                    check[num] = check[poll] + 1;
                    if (num == n * m) {
                        break;
                    }
                }
            }
        }
        System.out.println(check[n*m]);
    }
}
