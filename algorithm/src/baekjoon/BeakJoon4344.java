package baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BeakJoon4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        int stuNum = 0;
        int scores = 0;
        int higherThanAvgStuNum = 0;

        int testNum = Integer.parseInt(sc.nextLine());
        int[][] kk = new int[testNum][];
        float[] result = new float[testNum];

        for (int i = 0; i < testNum; i++) {
            st = new StringTokenizer(sc.nextLine());
            stuNum = Integer.parseInt(st.nextToken());
            kk[i] = new int[stuNum];
            for (int j = 0; j < stuNum; j++) {
                kk[i][j] = Integer.parseInt(st.nextToken());
                scores += kk[i][j];
            }

            for (int j = 0; j < stuNum; j++) {
                if (kk[i][j] > (float)(scores / stuNum)) {
                    higherThanAvgStuNum++;
                }
            }
            result[i] = ((float) higherThanAvgStuNum / (float) stuNum) * 100;
            higherThanAvgStuNum = 0;
            scores = 0;
        }

        for (float v : result) {
            System.out.printf("%.3f%%\n", v);
        }

    }
}
