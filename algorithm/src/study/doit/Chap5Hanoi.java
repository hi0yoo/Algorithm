package study.doit;

import java.util.Scanner;

public class Chap5Hanoi {

    // 하노이의 탑 문제. ringNum : 링의 개수
    public static void hanoi(int ringNum) {
        if (ringNum > 10) {
            throw new RuntimeException("Too many ring count. Now ringNum : " + ringNum);
        }

        moveRing(ringNum, 1, 3, factorial(ringNum));
    }

    public static void moveRing(int no, int x, int y, int ringNumFac) {
        if (no > 1) {
            moveRing(no - 1, x, 6 - x - y, ringNumFac);
        }

        System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if (no > 1) {
            moveRing(no - 1, 6 - x - y, y, ringNumFac);
        }
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("링의 개수를 입력하세요 : ");
        int ringNum = scanner.nextInt();
        System.out.println(factorial(ringNum));
        hanoi(ringNum);
    }
}
