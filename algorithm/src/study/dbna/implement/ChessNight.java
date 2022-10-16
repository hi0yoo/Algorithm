package study.dbna.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessNight {

    public static void main(String[] args) throws IOException {
        int[][] steps = {
                { 1,  2},
                { 1, -2},
                { 2,  1},
                { 2, -1},
                {-1,  2},
                {-1, -2},
                {-2,  1},
                {-2, -1}
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int x = chars[0] - 97;
        int y = chars[1] - 49;

        int count = 0;
        for (int i = 0; i < steps.length; i++) {
            int rx = x + steps[i][0];
            int ry = y + steps[i][1];
            if (rx >= 0 && rx < 8 && ry >= 0 && ry < 8) {
                count++;
            }
        }

        System.out.println(count);
    }
}
