package baekjoon.java.boj;

import java.util.Scanner;

public class BOJ11720 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        String sNum = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < sNum.length(); i++) {
            sum += (int) (sNum.charAt(i) - 48);
        }

        System.out.println(sum);
    }
}
