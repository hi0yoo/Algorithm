package programmers;

// 점찍기
public class Points {

    public static void main(String[] args) {
        long solution = solution(1, 5);
        System.out.println(solution);
    }

    private static long solution(int k, int d) {
        long answer = 1;
        answer += ((d / k) * 2);

        double pow = Math.pow(d, 2);
        for (int i = 1; i * k <= d; i++) {
            int num = i * k;
            answer += (int) Math.sqrt(pow - Math.pow(num, 2)) / k;
        }

        return answer;
    }
}
