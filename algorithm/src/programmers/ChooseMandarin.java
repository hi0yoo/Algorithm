package programmers;

import java.util.Arrays;

public class ChooseMandarin {

    public static void main(String[] args) {
        int k = 2;
//        int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3};
        int solution = solution(k, arr);
        System.out.println(solution);
    }

    private static int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] nums = new int[10_000_001];
        for (int i = 0; i < tangerine.length; i++) {
            nums[tangerine[i]]++;
        }
        Arrays.sort(nums);

        int count = 0;
        int point = nums.length - 1;
        while (count < k) {
            count += nums[point];
            answer++;
            point--;
        }

        return answer;
    }
}
