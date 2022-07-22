package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO 다시 풀어보기
public class BOJ11689 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자연수 n을 입력받는다.
        long n = Long.parseLong(br.readLine());
        // 결과값을 n으로 세팅.
        long result = n;

        // N의 가장 큰 소인수가 N의 제곱근보다 작다면, 모든 소인수는 N의 제곱근 보다 작다.
        // 만약 가장 큰 소인수가 N의 제곱근 보다 크더라도, 두번째로 큰 소인수는 N의 제곱근 보다 작다.

        // 2부터 1씩 늘려가며 n의 제곱근까지 수행한다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // 자연수 n이 i를 약수로 가지면 if 내부 수행.
            if (n % i == 0) {
                // 오일러 P 공식 적용
                // result = result * (1 - 1/p) = result - result/p
                result -= result / i;
                while (n % i == 0) {
                    // 다음 소인수를 찾기 위해 i로 나누어 떨어질 때 까지 i로 나눈다.
                    n /= i;
                }
            }
        }

        // 아직 약수가 남아있다면
        if (n > 1) {
            // 오일러 공식을 한번 더 적용한다.
            result -= result / n;
        }

        System.out.println(result);
    }
}
