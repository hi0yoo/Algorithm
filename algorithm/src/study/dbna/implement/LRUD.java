package study.dbna.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LRUD {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        int x = 0;
        int y = 0;

        String[] contents = new String[100];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = st.countTokens();
        for (int i = 0; i < tc; i++) {
            contents[i] = st.nextToken();
        }

        int count = 0;
        while (true) {
            if (contents[count] == null) {
                break;
            }

            switch (contents[count]) {
                case "L":
                    if (x > 0) {
                        x -= 1;
                    }
                    break;
                case "R":
                    if (x < n - 1) {
                        x += 1;
                    }
                    break;
                case "U":
                    if (y > 0) {
                        y -= 1;
                    }
                    break;
                case "D":
                    if (y < n - 1) {
                        y += 1;
                    }
                    break;
            }
            count++;
        }

        System.out.println((y + 1) + " " + (x + 1));
    }
}
