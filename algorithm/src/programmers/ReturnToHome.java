package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ReturnToHome {

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {
                {1, 2},
                {1, 4},
                {2, 4},
                {2, 5},
                {4, 5}
        };
        int[] sources = {1, 3, 5};
        int destination = 5;
        int[] solution = solution(n, roads, sources, destination);
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int INF = 9_999_999;
        int[] answer = new int[sources.length];

        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int start = roads[i][0];
            int end = roads[i][1];
            list[start].add(new Node(end, 1));
            list[end].add(new Node(start, 1));
        }

        // 최단 거리 테이블 생성 및 초기화
        int[] shortest = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            shortest[i] = INF;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost == o2.cost) {
                return o1.node - o2.node;
            }
            return o1.cost - o2.cost;
        });
        boolean[] visited = new boolean[n + 1];
        priorityQueue.add(new Node(destination, 0));
        shortest[destination] = 0;

        while (!priorityQueue.isEmpty()) {
            Node poll = priorityQueue.poll();
            int now = poll.node;

            if (!visited[now]) {
                visited[now] = true;

                int size = list[now].size();
                for (int i = 0; i < size; i++) {
                    Node node = list[now].get(i);

                    int pathNodeCost = node.cost;
                    if (now != node.node && pathNodeCost != INF) {
                        int fullCost = poll.cost + pathNodeCost;
                        shortest[node.node] = Math.min(shortest[node.node], fullCost);
                        priorityQueue.add(new Node(node.node, fullCost));
                    }
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            int a = shortest[source] == INF ? -1 : shortest[source];
            answer[i] = a;
        }

        return answer;
    }

    private static class Node {
        public int node;
        public int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
