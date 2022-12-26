package programmers;

import programmers.solution.DividePower;
import programmers.solution.Fatigue;
import programmers.solution.TableHashFunction;

public class Main {

    public static void main(String[] args) {
        TableHashFunction tableHashFunction = new TableHashFunction();
        int[][] data = {
                {2, 2, 6},
                {1, 5, 10},
                {4, 2, 9},
                {3, 8, 3}
        };
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(tableHashFunction.solution(data, col, row_begin, row_end));
    }
}
