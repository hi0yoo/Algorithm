package study.doit;

import java.util.Scanner;

public class Prac2Q7 {

    public static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result.concat(String.valueOf(s.charAt(i)));
        }
        return result;
    }

    public static String numToCd(int num, int cd) {
        String s = "";
        int quo = -1; // 몫
        int rem = -1; // 나머지
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // 1. 진수 |   나눌 수
        // 나눠지면 몫, ... 나머지
        // 몫이 진수보다 크면 반복
        // 몫이 진수보다 작으면 몫 ... 나머지 찍고 끝

        System.out.printf("%3d|%10d\n", cd, num);

        while (quo != 0) {
            quo = num / cd;
            rem = num % cd;

            if (quo > 0) {
                System.out.printf("%3d|%10d ... %d\n", cd, quo, rem);
                System.out.printf("%3s+%10s\n", "", "----------");
                num = num / cd;
                s = s.concat(String.valueOf(dchar.charAt(rem)));
            } else {
                System.out.printf("%14d ... %d\n", quo, rem);
                s = s.concat(String.valueOf(dchar.charAt(rem)));
            }
        }
        s = reverse(s);

        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("10진수를 기수 변환합니다.");
        System.out.print("변환하는 음이 아닌 정수 : ");
        int num = sc.nextInt();

        System.out.print("어떤 진수로 변환할까요?(2~36) : ");
        int cd = sc.nextInt();

        String s = numToCd(num, cd);

        System.out.println(cd + "진수로 " + s + "입니다.");
    }
}
