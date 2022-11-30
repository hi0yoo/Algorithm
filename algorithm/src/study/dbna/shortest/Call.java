package study.dbna.shortest;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Call {
    public static final int INF = 99999;
    public static void main(String[] args) throws IOException {
        /*
3 2 1
1 2 4
1 3 2
-> 2 4

5 6 1
1 2 2
1 3 4
1 5 3
2 3 1
3 4 7
5 4 1
-> 4 4
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n = 도시 개수, m = 통로 개수, c = 출발지 노드
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 경로 정보 초기화
        int[][] paths = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == j) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = INF;
                }
            }
        }

        // 경로 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // x = 출발지, y = 목적지, z = 비용
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            paths[x][y] = z;
        }

        // 최단 경로 테이블 : 1차원 테이블 생성
        int[] shortest = new int[n + 1];
        for (int i = 0; i < n+1; i++) {
            shortest[i] = INF;
        }
        // 방문 여부 테이블
        boolean[] visited = new boolean[n + 1];
        int total = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.cost)));

        // 출발 노드 설정
        shortest[c] = 0;
        priorityQueue.add(new Node(c, 0));

        while (!priorityQueue.isEmpty()) {
            // 우선순위 큐에서 노드를 꺼냄. node = 현재 노드
            Node poll = priorityQueue.poll();
            int now = poll.node;
            // 꺼낸 노드를 처리한 적이 없으면 수행한다.
            if (!visited[now]) {
                // 방문 처리
                visited[now] = true;
                total++; // 방문 개수 증가
                // 현재 노드와 인접한 노드를 우선순위 큐에 넣는다.
                for (int i = 1; i < n+1; i++) {
                    int pathNodeCost = paths[now][i];
                    if (now != i && pathNodeCost != INF) {
                        int nowCost = pathNodeCost + poll.cost;
                        // 기존 최단 거리와 현재 노드에서의 최단 거리를 비교하여 최단 거리 테이블 갱신
                        shortest[i] = Math.min(shortest[i], nowCost);
                        // 우선순위 큐에 넣음
                        priorityQueue.add(new Node(i, nowCost));
                    }
                }
            }
        }

        int maxTime = Arrays.stream(shortest).filter(i -> i != INF).max().orElseThrow();
        System.out.println(total-1 + " " + maxTime);

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n+1; i++) {
            sb.append(shortest[i] + " ");
        }
        System.out.println("=== shortest cost table ===");
        System.out.println(sb);
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
