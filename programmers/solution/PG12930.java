package programmers.solution;

/*
    link : https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
public class PG12930 {

    public static String s1 = "try hello world";

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 알파벳이면
            if (Character.isAlphabetic(c)) {
                if (flag) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
                flag = !flag;
            }
            // 알파벳이 아니면
            else {
                flag = true;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
