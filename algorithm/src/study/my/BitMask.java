package study.my;

public class BitMask {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < 1 << arr.length; i++) {
            if (Integer.bitCount(i) == 2) {
                for (int j = 0; j < arr.length; j++) {
                    if ((i & (1 << j)) > 0) {
                        System.out.printf("%2d", arr[j]);
                    }
                }
                System.out.println();
            }
        }
    }
}
