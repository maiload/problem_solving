package algorithm.part1.time_complexity;

import java.util.Scanner;

public class Main_10158_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int num = sc.nextInt();
        boolean x = true, y = true;

        for (int i = 0; i < num; i++) {
            if (x) {
                row++;
            } else {
                row--;
            }
            if (y) {
                col++;
            } else {
                col--;
            }
            if (row == w) {
                x = false;
            } else if (row == 0) {
                x = true;
            }
            if (col == h) {
                y = false;
            } else if (col == 0) {
                y = true;
            }
            System.out.printf("current: %d,%d\n", row, col);
        }
        System.out.printf("%d %d", row, col);
    }
}
