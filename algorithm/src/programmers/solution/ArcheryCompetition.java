package programmers.solution;

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
        // 최대 차이 기록
        int maxSub = 0;
        // 최대 차이일 때 라이언이 점수를 얻을 배열 bitmask
        int resultNum = 0;
        // 라이언이 쏜 화살 개수 카운팅
        int count;
        for (int i = (1 << info.length) - 1; i >= 0; i--) {
            count = 0;
            // j = 10 부터 시작
            for (int j = info.length - 1; j >= 0; j--) {
                // j 번째를 쏜다고 결정 되었다면 화살 수 카운팅
                if ((i & (1 << j)) > 0) {
                    count += (info[info.length - 1 - j] + 1);
                }
            }
            // 주어진 화살 수 보다 같거나 작아야 가능
            if (count <= n) {
                // 어피치 점수 계산을 위해 이진수 변환
                int ryanNum = i;
                int apeachNum = calApeachNum(ryanNum, info);

                // 라이언 어피치 점수 계산 : 비트수 -> 점수로 변환
                int ryanScore = calScore(ryanNum);
                int apeachScore = calScore(apeachNum);
                // 둘의 점수차
                int currentSub = ryanScore - apeachScore;
                // 라이언이 더 커야 이김
                if (currentSub > 0) {
                    // 현재 점수 차가 이전에 기록된 값보다 크면 교체
                    if (currentSub > maxSub) {
                        maxSub = currentSub;
                        resultNum = ryanNum;
                    }
                    // 점수 차가 같으면
                    if (currentSub == maxSub) {
                        // 비교해서 적은 점수를 더 많이 맞힌 수로 기록
                        resultNum = compare(ryanNum, resultNum, info);
                    }
                }
            }
        }

        // 결과 숫자가 0 이면 이길 수 없다는 뜻.
        if (resultNum == 0) {
            return new int[]{-1};
        }

        count = n;
        answer = new int[info.length];
        for (int i = 0; i < answer.length - 1; i++) {
            // i 번째 점수(i=0 -> 점수=10, i=10 -> 점수=0)를 얻는다면,
            // 어피치가 해당 점수에 맞힌 화살 + 1 만큼 라이언의 화살 갯수 차감
            if ((resultNum & (1 << (answer.length - 1 - i))) > 0) {
                // 어피치가 해당 점수에 맞힌 화살 + 1
                int now = info[i] + 1;
                answer[i] = now;
                count -= now;
            }
        }
        // 라이언이 쏠 수 있는 화살이 남았다면
        if (count > 0) {
            // 0점에 모두 쏜다.
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

    // 라이언이 ryanNum 비트의 점수를 얻을 때, 어피치가 얻는 점수의 비트 넘버
    private static int calApeachNum(int ryanNum, int[] info) {
        int apeachNum = 0;
        for (int i = info.length - 1; i >= 0; i--) {
            if (info[info.length - 1 - i] > 0) {
                apeachNum += (1 << (i));
            }
        }
        return apeachNum & (apeachNum ^ ryanNum);
    }

    // a, b 비트 중 어떤 수가 더 적은 점수를 많이 맞혔는지 비교
    private static int compare(int a, int b, int[] info) {
        // a가 쏜 화살 카운팅
        int aArrow = 0;
        // b가 쏜 화살 카운팅
        int bArrow = 0;
        for (int i = 0; i < 11; i++) {
            if ((a & (1 << 10 - i)) > 0) {
                aArrow += (info[i] + 1);
            }
            if ((b & (1 << 10 - i)) > 0) {
                bArrow += (info[i] + 1);
            }
        }

        // a에 쏜 화살이 더 많다면 b가 0점이 더 많음. b 반환
        if (aArrow > bArrow) {
            return b;
        }
        // b에 쏜 화살이 더 많다면 a가 0점이 더 많음. a 반환
        else if (aArrow < bArrow) {
            return a;
        }
        // a,b 쏜 화살이 같다면
        else {
            // 0점부터 맞힌 수 카운팅
            for (int i = info.length - 1; i >= 0; i--) {
                // a일 때 (10-i)점을 맞힌 화살 수
                int ai = (a & (1 << 10 - i)) > 0 ? info[i] + 1 : 0;
                // b일 때 (10-i)점을 맞힌 화살 수
                int bi = (b & (1 << 10 - i)) > 0 ? info[i] + 1 : 0;
                // i점을 a가 더 많이 맞혔다면 a 반환
                if (ai > bi) {
                    return a;
                }
                // i점을 b가 더 많이 맞혔다면 b 반환
                if (bi > ai) {
                    return b;
                }
            }
        }

        // a, b가 같은 수 일때 -> 같은 수가 될 수 없음. 컴파일 오류 해결을 위함
        return 0;
    }
}
