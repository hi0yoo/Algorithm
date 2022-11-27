package study.dbna.priority;

import java.util.*;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getNum).reversed());

        priorityQueue.add(new Node(7, "aaaaaaa"));
        priorityQueue.add(new Node(9, "bbbbb"));
        priorityQueue.add(new Node(3, "casgva"));
        priorityQueue.add(new Node(6, "wrt"));
        priorityQueue.add(new Node(1, "ertyjserg"));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            System.out.println(node.getNum() + ", " + node.getName());
        }
    }

    private static class Node {
        private Integer num;
        private String name;

        public Node(int num, String name) {
            this.num = num;
            this.name = name;
        }

        public Integer getNum() {
            return num;
        }

        public String getName() {
            return name;
        }
    }
}
