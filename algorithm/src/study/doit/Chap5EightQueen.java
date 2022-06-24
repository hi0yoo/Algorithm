package study.doit;

public class Chap5EightQueen {
    public static int[] pos = new int[8];
    public static boolean[] rowFlag = new boolean[8];
    public static boolean[] fromBottomToTopFlag = new boolean[15];
    public static boolean[] fromTopToBottomFlag = new boolean[15];

    public static void set(int col) {
        for (int i = 0; i < 8; i++) {
            if (rowFlag[i] == false &&
                    fromBottomToTopFlag[col + i] == false &&
                    fromTopToBottomFlag[col - i + 7] == false) {
                pos[col] = i;
                if (col == 7) {
                    print();
                    System.out.println("----------------------------------");
                } else {
                    rowFlag[i] = fromBottomToTopFlag[col + i] = fromTopToBottomFlag[col - i + 7] = true;
                    set(col + 1);
                    rowFlag[i] = fromBottomToTopFlag[col + i] = fromTopToBottomFlag[col - i + 7] = false;
                }
            }
        }
    }

    public static void print() {
        int[][] board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            board[i][pos[i]] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
//        for (int i = 0; i < 8; i++) {
//            System.out.printf("%2d", pos[i]);
//        }
//        System.out.println();
    }

    public static void main(String[] args) {
        set(0);
    }

}
