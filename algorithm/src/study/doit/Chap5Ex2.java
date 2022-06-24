package study.doit;

public class Chap5Ex2 {

    // 유클리드 호제법으로 최대공약수
    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        int x = 22;
        int y = 8;

        System.out.println(gcd(x, y));
    }
}
