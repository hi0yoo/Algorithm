package study.dbna.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class maze {

    private static int[][] maze;
    private static int n;
    private static int m;
    private static int count = 0;

    /*
5 6
101010
111111
000001
111111
111111
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int pos = poll(queue);
            int x = pos / m;
            int y = pos % m;
            if (x == n - 1 && y == m - 1) {
                break;
            }
            if (x - 1 >= 0 && y < m && maze[x-1][y] == 1) {
                queue.add((x-1)*m+y);
                maze[x-1][y] = maze[x][y] + 1;
            }
            if (x + 1 < n && y < m && maze[x+1][y] == 1) {
                queue.add((x+1)*m+y);
                maze[x+1][y] = maze[x][y] + 1;
            }
            if (x < n && y - 1 >= 0 && maze[x][y-1] == 1) {
                queue.add(x*m+y-1);
                maze[x][y-1] = maze[x][y] + 1;
            }
            if (x < n && y + 1 < m && maze[x][y+1] == 1) {
                queue.add(x*m+y+1);
                maze[x][y+1] = maze[x][y] + 1;
            }
        }

        System.out.println(maze[n-1][m-1]);
    }

    private static int poll(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        return -1;
    }
}
