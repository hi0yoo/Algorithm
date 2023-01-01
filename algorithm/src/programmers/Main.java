package programmers;

import programmers.solution.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        System.out.println(Arrays.deepToString(towerOfHanoi.solution(2)));
    }
}
