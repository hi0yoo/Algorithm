package study.doit;

public class Chap2Ex10 {

    public static final int MAX_NUM = 1000;

    // 2 ~ 1000 사이의 소수 출력
    public static void main(String[] args) {

        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n = 3; n <= MAX_NUM; n += 2) {
            int i;
            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }
            if (ptr == i) {
                prime[ptr++] = n;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }
        System.out.println("나눗셈 횟수 : " + counter);
    }
}
