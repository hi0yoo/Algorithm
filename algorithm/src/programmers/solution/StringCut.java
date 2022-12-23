package programmers.solution;

public class StringCut {

    public static void main(String[] args) {
//        String s = "banana";
//        String s = "abracadabra";
        String s = "aaabbaccccabba";
        int solution = solution(s);
        System.out.println(solution);
    }

    private static int solution(String s) {
        int answer = 0;

        int pointer = 0;
        int lastIdx = s.length() - 1;
        while (pointer <= lastIdx) {
            char start = s.charAt(pointer);
            int startCount = 1;
            int elseCount = 0;
            while (pointer < lastIdx && startCount != elseCount) {
                pointer++;
                char c = s.charAt(pointer);
                if (start == c) {
                    startCount++;
                } else {
                    elseCount++;
                }
            }
            pointer++;
            answer++;
        }

        return answer;
    }
}
