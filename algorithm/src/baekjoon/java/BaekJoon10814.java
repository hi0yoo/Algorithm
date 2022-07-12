package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Member[] a = new Member[n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(a, ((o1, o2) -> o1.age - o2.age));

        for (int i = 0; i < n; i++) {
            System.out.println(a[i].age + " " + a[i].name);
        }
    }

    static class Member {
        public int age;
        public String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
