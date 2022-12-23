package programmers.solution;

import java.util.ArrayList;
import java.util.List;

public class MakeHamburger {
    private static int[] sol = {1, 2, 3, 1};

    public static void main(String[] args) {
        int[] ingredient = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 2, 3, 1, 1, 2, 3, 1};
        int solution = solution(ingredient);
        System.out.println(solution);
    }

    private static int solution(int[] ingredient) {
        // 1: 빵, 2: 야채, 3: 고기
        // 햄버거 만드는 순서 : 빵-야채-고기-빵 : 1-2-3-1
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        int len = ingredient.length;
        for (int i = 0; i < len; i++) {
            arr.add(ingredient[i]);

            int size = arr.size();
            if (size >= 4) {
                if (arr.get(size - 4) == sol[0]
                        && arr.get(size - 3) == sol[1]
                        && arr.get(size - 2) == sol[2]
                        && arr.get(size - 1) == sol[3]) {
                    for (int j = size-1; j >= size-4; j--) {
                        arr.remove(j);
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}
