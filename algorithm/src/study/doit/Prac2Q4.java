package study.doit;

import java.util.Arrays;

public class Prac2Q4 {

    public static void copy(int[] a, int[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        System.out.println(Arrays.equals(a, b));

        copy(a, b);

        System.out.println(Arrays.equals(a, b));
    }
}
