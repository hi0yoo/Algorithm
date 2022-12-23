package programmers.solution;

import java.util.Arrays;

public class ExtendMultiplicationTable {

    public static void main(String[] args) {
        int e = 8;
        int[] starts = {1, 3, 7};
        int[] solution = solution(e, starts);
        System.out.println(Arrays.toString(solution));
    }

    public static class Point {
        int number, count;

        public Point(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public String toString() {
            return "{" + number + ", " + count + "}";
        }
    }

    private static int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];

        Point[] points = new Point[e];
        for (int i = 1; i <= e; i++) {
            points[i - 1] = new Point(i, 1);
        }

        for (int i = 2; i <= e; i++)
            for (int j = 1; j <= e / i; j++)
                points[i * j - 1].count++;

        Arrays.sort(
                points,
                (o1, o2) -> {
                    int subCount = o1.count - o2.count;
                    if (subCount == 0) {
                        return o1.number - o2.number;
                    }
                    return subCount * (-1);
                }
        );

        for (int i = 0; i < starts.length; i++) {
            for (int j = 0; j < e; j++) {
                if (points[j].number >= starts[i]) {
                    answer[i] = points[j].number;
                    break;
                }
            }
        }

        return answer;
    }
}
