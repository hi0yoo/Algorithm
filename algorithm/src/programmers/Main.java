package programmers;

import programmers.solution.*;

public class Main {

    public static void main(String[] args) {
        ContinuousSubsequenceSumCount continuousSubsequenceSumCount = new ContinuousSubsequenceSumCount();
        int[] arr = {7, 9, 1, 1, 4};
        System.out.println(continuousSubsequenceSumCount.solution(arr));
    }
}
