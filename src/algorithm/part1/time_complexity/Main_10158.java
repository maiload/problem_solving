package algorithm.part1.time_complexity;

import java.util.Scanner;

public class Main_10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int num = sc.nextInt();

        int r = ((row + num) / w) % 2 == 0 ? (row + num) % w : w - ((row + num) % w);
        int c = ((col + num) / h) % 2 == 0 ? (col + num) % h : h - ((col + num) % h);

        System.out.printf("%d %d", r, c);
    }
}
