package programmers;

import programmers.solution.Fatigue;

public class Main {

    public static void main(String[] args) {
        Fatigue fatigue = new Fatigue();
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        System.out.println(fatigue.solution(k, dungeons));
    }
}
