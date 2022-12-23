package programmers.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {

    public static void main(String[] args) {
        int[] arr = {10, 100, 20, 150, 1, 100, 200};
        int[] solution = solution(3, arr);
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            priorityQueue.add(score[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            answer[i] = priorityQueue.peek();
        }

        return answer;
    }
}
