package baekjoon.java.boj;

import java.io.*;

public class BOJ3085 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) arr[i][j] = s.charAt(j);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char cy = arr[i][0];
            int k = 1;
            int c = 1;
            for (int j = 1; j < n; j++) {
                if (cy == arr[i][j]) {
                    c++;
                    if (c > k) k = c;
                } else {
                    cy = arr[i][j];
                    c = 1;
                }
            }
            if (k > answer) answer = k;
        }

        for (int j = 0; j < n; j++) {
            char cx = arr[0][j];
            int k = 1;
            int c = 1;
            for (int i = 1; i < n; i++) {
                if (cx == arr[i][j]) {
                    c++;
                    if (c > k) k = c;
                } else {
                    cx = arr[i][j];
                    c = 1;
                }
            }
            if (k > answer) answer = k;
        }

        int[] dx = {1, 0};
        int[] dy = {0, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < 2; d++) {
                    if (j + dx[d] < n && i + dy[d] < n && arr[i][j] != arr[i + dy[d]][j + dx[d]]) {
                        char tmp = arr[i][j];
                        arr[i][j] = arr[i + dy[d]][j + dx[d]];
                        arr[i + dy[d]][j + dx[d]] = tmp;

                        if (dy[d] == 0) {
                            char last = arr[0][j];
                            int max = 1;
                            int count = 1;
                            for (int y = 1; y < n; y++) {
                                if (last == arr[y][j]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[y][j];
                                    count = 1;
                                }
                            }

                            last = arr[0][j + dx[d]];
                            count = 1;
                            for (int y = 1; y < n; y++) {
                                if (last == arr[y][j + dx[d]]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[y][j + dx[d]];
                                    count = 1;
                                }
                            }

                            last = arr[i][0];
                            count = 1;
                            for (int x = 1; x < n; x++) {
                                if (last == arr[i][x]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[i][x];
                                    count = 1;
                                }
                            }

                            if (max > answer) answer = max;
                        }

                        if (dx[d] == 0) {
                            char last = arr[i][0];
                            int max = 1;
                            int count = 1;
                            for (int x = 1; x < n; x++) {
                                if (last == arr[i][x]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[i][x];
                                    count = 1;
                                }
                            }

                            last = arr[i + dy[d]][0];
                            count = 1;
                            for (int x = 1; x < n; x++) {
                                if (last == arr[i + dy[d]][x]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[i + dy[d]][x];
                                    count = 1;
                                }
                            }

                            last = arr[0][j];
                            count = 1;
                            for (int y = 1; y < n; y++) {
                                if (last == arr[y][j]) {
                                    count++;
                                    if (count > max) max = count;
                                } else {
                                    last = arr[y][j];
                                    count = 1;
                                }
                            }

                            if (max > answer) answer = max;
                        }

                        arr[i + dy[d]][j + dx[d]] = arr[i][j];
                        arr[i][j] = tmp;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
