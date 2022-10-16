package study.dbna.implement;

import java.io.*;
import java.util.StringTokenizer;

public class GameDevelop {

    static int count = 0;
    static int x = 0;
    static int y = 0;
    static int direction = 0;
    static int[][] directions = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵크기 세로 n, 가로 m
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 초기 캐릭터 위치 x, y
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken()); // 0:북, 1:동, 2:남, 3:서

        // 0:육지, 1:바다, 2:방문함
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
            3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는,
                바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
                단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
         */
        while (kk(map)) {

        }

        System.out.println(count);
    }

    /*
         1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례로 갈 곳을 정한다.
     */
    private static boolean checkMap(int[][] map) {
        turn();
        int rx = x + directions[direction][0];
        int ry = y + directions[direction][1];
        if (rx >= n || ry >= m) {
            return false;
        }

        if (map[rx][ry] == 0) {
            return true;
        }
        return false;
    }

    /*
         2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면,
             왼쪽 방향으로 회전한 다음, 왼쪽으로 한 칸을 전진한다.
             왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
     */
    private static boolean kk(int[][] map) {
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (checkMap(map)) {
                    move(map);
                    return true;
                }
            }
            return back(map);
        }
    }

    private static void move(int[][] map) {
        x = x + directions[direction][0];
        y = y + directions[direction][1];
        map[x][y] = 2;
        count++;
    }

    private static boolean back(int[][] map) {
        int toBack = direction - 2;
        if (toBack < 0) {
            toBack += 4;
        }
        int x1 = x + directions[toBack][0];
        int y1 = y + directions[toBack][1];

        if (x1 >= n || y1 >= m) {
            return false;
        }

        if (map[x1][y1] == 1) {
            return false;
        }

        x = x1;
        y = y1;
        return true;
    }

    private static void turn() {
        direction--;
        if (direction < 0) {
            direction += 4;
        }
    }
}
