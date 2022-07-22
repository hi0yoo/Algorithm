package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {

    public static void main(String[] args) throws IOException {

        // 수의 개수 n과 질문의 개수 m을 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n만큼 반복하여 수를 입력받고 구간합을 배열에 저장한다.
        int s[] = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int k = 1; k < s.length; k++) {
            s[k] = s[k-1] + Integer.parseInt(st.nextToken());
        }

        // 질문에 대한 답 solution[m]을 생성
        int solution[] = new int[m];
        // 시작지점 i와 종료지점 j를 입력받고 배열에서 해당 구간 합을 solution 배열에 저장.
        for (int k = 0; k < solution.length; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            solution[k] = s[j] - s[i-1];
        }

        // 답을 출력한다.
        for (int k = 0; k < solution.length; k++) {
            System.out.println(solution[k]);
        }


    }
}
