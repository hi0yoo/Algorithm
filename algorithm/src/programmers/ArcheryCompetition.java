package programmers;

import java.util.Arrays;

public class ArcheryCompetition {
    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        // 	[0,2,2,0,1,0,0,0,0,0,0]

//        int n = 1;
//        int[] info = {1,0,0,0,0,0,0,0,0,0,0};
        // [-1]

//        int n = 9;
//        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        // 	[1,1,2,0,1,2,2,0,0,0,0]

//        int n = 10;
//        int[] info = {0,0,0,0,0,0,0,0,3,4,3};
        // [1,1,1,1,1,1,1,1,0,0,2]

        int[] solution = solution(n, info);
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int n, int[] info) {
        int[] answer;
        int maxSub = 0;
        int resultNum = 0;
        int count;
        for (int i = (1 << info.length) - 1; i >= 0; i--) {
            count = 0;
            // j = 10 부터 시작
            for (int j = info.length - 1; j >= 0; j--) {
                // j 번째를 쏜다고 결정 되었다면
                if ((i & (1 << j)) > 0) {
                    count += (info[info.length - 1 - j] + 1);
                }
            }
            // 화살 수 보다 같거나 작아야 가능
            if (count <= n) {
                // 어피치 점수 계산을 위해 이진수 변환
                int ryanNum = i;
                int apeachNum = calApeachNum(ryanNum, info);

                // 라이언 어피치 점수 계산
                int ryanScore = calScore(ryanNum);
                int apeachScore = calScore(apeachNum);
                // 둘의 점수차
                int currentSub = ryanScore - apeachScore;
                // 라이언이 더 커야 이김
                if (currentSub > 0) {
                    // 점수 차가 이전에 기록된 값보다 크면 교체
                    if (currentSub > maxSub) {
                        maxSub = currentSub;
                        resultNum = ryanNum;
                    }
                    // 점수 차가 같으면
                    else if (currentSub == maxSub) {
                        resultNum = compare(n, ryanNum, resultNum, info);
                    }
                }
            }
        }

        // 결과 숫자가 0 이면 이길 수 없음.
        if (resultNum == 0) {
            return new int[]{-1};
        }

        count = n;
        answer = new int[info.length];
        for (int i = 0; i < answer.length - 1; i++) {
            int pos = answer.length - 1 - i;
            if ((resultNum & (1 << pos)) > 0) {
                int now = info[i] + 1;
                answer[i] = now;
                count -= now;
            }
        }
        if (count > 0) {
            answer[answer.length - 1] = count;
        }

        return answer;
    }

    private static int calScore(int num) {
        int score = 0;
        for (int i = 10; i >= 0; i--) {
            if ((num & (1 << i)) > 0) {
                score += i;
            }
        }
        return score;
    }

    private static int calApeachNum(int ryanScore, int[] info) {
        int apeachNum = 0;
        for (int i = info.length - 1; i >= 0; i--) {
            if (info[info.length - 1 - i] > 0) {
                apeachNum += (1 << (i));
            }
        }
        return apeachNum & (apeachNum ^ ryanScore);
    }

    private static int compare(int n, int a, int b, int[] info) {
        int aArrow = 0;
        for (int i = 0; i < 11; i++) {
            if ((a & (1 << 10 - i)) > 0) {
                aArrow += (info[i] + 1);
            }
        }

        int bArrow = 0;
        for (int i = 0; i < 11; i++) {
            if ((b & (1 << 10 - i)) > 0) {
                bArrow += (info[i] + 1);
            }
        }

        // a에 쏜 화살이 더 많다면 b 반환
        if (aArrow > bArrow) {
            return b;
        } else if (aArrow < bArrow) {
            return a;
        } else {
            // 10 부터 시작
            for (int i = info.length - 1; i >= 0; i--) {
                int ai = (a & (1 << 10 - i)) > 0 ? info[i] + 1 : 0;
                int bi = (b & (1 << 10 - i)) > 0 ? info[i] + 1 : 0;
                if (ai > bi) {
                    return a;
                }
                if (bi > ai) {
                    return b;
                }
            }
        }

        return 0;
    }
}
