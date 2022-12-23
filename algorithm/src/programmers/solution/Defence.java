package programmers.solution;

import java.util.PriorityQueue;

public class Defence {

    public static void main(String[] args) {
        int n = 8;
        int k = 3;
        int[] enemy = {1, 6, 2, 6, 3, 2, 7};
        int solution = solution(n, k, enemy);
        System.out.println(solution);
    }

    private static int solution(int n, int k, int[] enemy) {
        /*
        n : 초기 병사 수
        k : 무적권 개수(무적권 1 당 라운드 1 통과)
        enemy[i] : 라운드 적 수
        */
        int answer = 0;

        if (k == enemy.length) {
            return enemy.length;
        }

        int count = 0;
        int remain = n;
        int i;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        for (i = 0; i < enemy.length; i++) {
            int current = enemy[i];
            priorityQueue.add(current);
            remain -= current;

            if (remain < 0) {
                if (count < k) {
                    remain += priorityQueue.poll();
                    count++;
                } else {
                    break;
                }
            }
        }
        answer = i;

        return answer;
    }
}
