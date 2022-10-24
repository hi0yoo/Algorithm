package baekjoon.java.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    private static int[] arr;
    private static List<Card> cards;
    private static Card lastCard;
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        cards = new ArrayList<>();
        lastCard = new Card(arr[0]);
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                if (arr[i] == lastCard.getNum()) {
                    lastCard.increase();
                } else {
                    cards.add(lastCard);
                    lastCard = new Card(arr[i]);
                }
            }
        }
        cards.add(lastCard);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int v = binarySearch(target, 0, cards.size() - 1);
            sb.append(v);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static class Card {
        private int num;
        private int count;

        public Card(int num) {
            this.num = num;
            this.count = 1;
        }

        public void increase() {
            count++;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }

    private static int binarySearch(int target, int start, int end) {
        int mid = (start + end) / 2;
        Card card = cards.get(mid);
        if (target == card.getNum()) {
            return card.getCount();
        }
        if (start >= end) {
            return 0;
        }

        if (target < card.getNum()) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }
}
