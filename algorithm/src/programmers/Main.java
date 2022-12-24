package programmers;

import programmers.solution.DividePower;
import programmers.solution.Fatigue;

public class Main {

    public static void main(String[] args) {
        DividePower dividePower = new DividePower();
        int n = 9;
        int[][] wires = {
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 6},
                {4, 7},
                {7, 8},
                {7, 9}
        };
        System.out.println(dividePower.solution(n, wires));
    }
}
