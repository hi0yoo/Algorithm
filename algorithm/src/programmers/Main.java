package programmers;

import programmers.solution.*;

public class Main {

    public static void main(String[] args) {
        GameMapShortestPath gameMapShortestPath = new GameMapShortestPath();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(gameMapShortestPath.solution(maps));
    }
}
