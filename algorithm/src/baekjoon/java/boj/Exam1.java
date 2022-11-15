package baekjoon.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N개의 숫자가 나열되어 있다. 각각의 값은 1, 2, 3 중에 하나이다.
이 수열의 연속된 일부분에 뒤집기를 할 수 있다.
여기서 뒤집기란 1을 3으로, 3을 1로 바꾸는 것이다. 2는 바뀌지 않는다.
주어진 수열에 한 번 이하의 뒤집기를 하여 얻을 수 있는 가장 큰 전체 합을 구하라
한번 이하이기 때문에 뒤집기를 하지 않을 수도 있음에 주의하라.

예제 입력 1)
n = 3, { 1, 3, 3 }
예제 결과 1)
9

예제 입력 2)
n = 5, { 3, 1, 2, 1, 2 }
예제 결과 2)
13

문제
1) n = 5, { 3, 1, 1, 3, 3 } -> { 3, 3, 3, 3, 3 } = 15
입력
5
3, 1, 1, 3, 3
출력
15

2) n = 7, { 2, 3, 3, 1, 1, 1, 3 } -> { 2, 3, 3, 3, 3, 3, 3 } = 20
입력
7
2, 3, 3, 1, 1, 1, 3
출력
20

3) n = 9, { 2, 3, 3, 3, 3, 2, 2, 2, 3 } -> 그대로 = 15 + 8 = 23
입력
9
2, 3, 3, 3, 3, 2, 2, 2, 3
출력
23

4) n = 11, { 2, 2, 1, 1, 1, 1, 2, 1, 2, 3, 3 } -> { 2, 2, 3, 3, 3, 3, 2, 3, 2, 3, 3 } = 29
입력
11
2, 2, 1, 1, 1, 1, 2, 1, 2, 3, 3
출력
29

5) n = 14, { 3, 2, 1, 1, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1 } -> { 3, 2, 1, 1, 3, 3, 3, 3, 1, 3, 3, 3, 3, 3 } = 30 + 2 + 3 = 35
입력
14
3, 2, 1, 1, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1
출력
35
 */
public class Exam1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            a[i] = num;
            sum += num;
        }
        // for (배열의 처음부터 끝까지 수행한다) {
        //  처음 1이 나온 후, 3이 나오기 전 까지 count 변수를 1씩 증가시킨다. 3을 만나면 count 값을 tmpCount 변수에 저장한다. count 변수를 0으로 초기화한다.
        //  다시 1이 나오면 또 3이 나오기 전 까지 count 변수를 1씩 증가시킨다. 3을 만나면 현재 max(count, tmpCount)의 값을 tmpCount 변수에 저장. count 변수를 0으로 초기화 한다.
        //  배열의 마지막까지 위 과정을 반복한다.
        // }
        // 기존 배열의 총합 + (tmpCount * 2)를 하여 값을 출력한다. tmpCount 는 연속된 1의 최대 갯수이다.

        int tmpCount = 0; // 연속된 1의 갯수의 최대값을 임시 저장하는 변수.
        int count = 0; // 현재 세고있는 연속된 1의 갯수를 담는 변수. 3을 만나면 tmpCount 와 비교하여 더 큰 값을 저장한다.
        boolean isCounting = false; // 1 갯수를 세는 중인지 아닌지를 확인하기 위한 변수.
        for (int i = 0; i < n; i++) {
            // 배열의 원소 값이 1이면 개수를 새눈 중이기 때문에 doCounting = true 로 하고, count 값 1 증가.
            if (a[i] == 1) {
                isCounting = true;
                count++;
            } else if (a[i] == 3) { // 배열의 원소 값이 3이면 1 갯수 세는거 중지.
                isCounting = false;
            }

            // 1 갯수를 세는 중이 아니고, 세고있는 갯수가 0보다 크면 수행. 또는 반복이 마지막 번째이면 수행.
            if ((!isCounting && count > 0) || i == n - 1) {
                tmpCount = Math.max(count, tmpCount);
                count = 0;
            }
        }

        sum = sum + (tmpCount * 2);
        System.out.println(sum);
    }
}
