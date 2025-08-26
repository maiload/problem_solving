package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_2840 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();   // 25
        int K = sc.nextInt();   // 100
        char[] circle = new char[N];

        int idx = 0;
        for (int i = 0; i < K; i++) {
            int count = sc.nextInt();
            char ch = sc.next().charAt(0);
            idx = (idx + count) % N;
            if (circle[idx] != 0 && circle[idx] != ch) {
                System.out.println("!");
                return;
            } else {
                circle[idx] = ch;
            }
        }

        for (int i = 0; i < N; i++) {
            char ch = circle[(i + idx + 1) % N];
            if (ch == 0) {
                sb.append('?');
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb.reverse());
    }
}
