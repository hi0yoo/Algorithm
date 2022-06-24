package study.doit;

public class Prac2Q5 {

    public static void rcopy(int[] a, int[] b) {
        if (a.length == b.length) {

            for (int i=0; i<a.length; i++) {
                b[i] = a[a.length - 1 - i];
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {11, 22, 33, 44, 55};

        System.out.println("a");
        printArray(a);

        System.out.println("b");
        printArray(b);

        System.out.println("-----------------------");
        rcopy(a, b);

        System.out.println("a");
        printArray(a);

        System.out.println("b");
        printArray(b);
    }
}
