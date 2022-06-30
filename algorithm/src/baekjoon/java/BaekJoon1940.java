package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1940 {

    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void sort(int[] array, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = array[(pl + pr) / 2];

        do {
            while (array[pl] < pivot) pl++;
            while (array[pr] > pivot) pr--;
            if (pl <= pr) swap(array, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) sort(array, left, pr);
        if (pl < right) sort(array, pl, right);
    }

    public static void main(String[] args) throws IOException {
        // 재료 개수 n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // 갑옷 제작에 필요한 값 m 입력
        int m = Integer.parseInt(br.readLine());

        // 재료의 고유 번호를 담을 배열 a 생성
        int[] a = new int[n];
        // a에 고유 번호 입력 : n 만큼 반복
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // a 정렬
        sort(a, 0, n-1);

        // firstIndex, secondIndex, count 설정
        int firstIndex = 0;
        int secondIndex = n-1;
        int count = 0;

        while (firstIndex < secondIndex) {
            if (a[firstIndex] + a[secondIndex] > m) {
                secondIndex--;
            } else if (a[firstIndex] + a[secondIndex] < m) {
                firstIndex++;
            } else {
                count++;
                firstIndex++;
                secondIndex--;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
