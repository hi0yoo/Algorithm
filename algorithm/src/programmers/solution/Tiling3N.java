package programmers.solution;

public class Tiling3N {
    /*
    가로 길이 2, 세로 길이 1 타일 있음
    가로 길이 n, 세로 길이 3 바닥을 가득 채우려고 함

    직사각형을 채우는 방법의 수를 구하라.

    n이 홀수이면 직사각형을 채우지 못한다.
    따라서 n은 짝수임.

    n = 4 -> result = 11
    */
    public int solution(int n) {
        int mod = 1_000_000_007;
        int[] dp = new int[n / 2 + 1];
        // dp[i] -> i * 2 인 경우
        if (n >= 2) dp[1] = 3;
        if (n >= 4) dp[2] = 11;
        for (int i = 3; i < dp.length; i++) {
            long sum = ((long) (dp[i - 1] % mod) * dp[1]) % mod;
            for (int j = i - 2; j >= 1; j--) {
                sum += ((dp[j] % mod) * 2) % mod;
            }
            dp[i] += (sum + 2) % mod;
        }
        return dp[n / 2];
    }

}
