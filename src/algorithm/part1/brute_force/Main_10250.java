package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int C = sc.nextInt();
            int x = C / H + 1;
            int yy = C % H;
            String xx = String.format("%02d", x);
            sb.append(yy).append(xx);
            if (i != T - 1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
