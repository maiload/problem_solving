package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_1730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int row = 0;
        int col = 0;
        String cmd = sc.next();
        for (char c : cmd.toCharArray()) {
            switch (c) {
                case 'U':
                    if (row - 1 == -1) break;
                    draw(map, row, col, 124);
                    row -= 1;
                    draw(map, row, col, 124);
                    break;
                case 'D':
                    if (row + 1 == N) break;
                    draw(map, row, col, 124);
                    row += 1;
                    draw(map, row, col, 124);
                    break;
                case 'L':
                    if (col - 1 == -1) break;
                    draw(map, row, col, 45);
                    col -= 1;
                    draw(map, row, col, 45);
                    break;
                case 'R':
                    if (col + 1 == N) break;
                    draw(map, row, col, 45);
                    col += 1;
                    draw(map, row, col, 45);
                    break;
            }
//            System.out.printf("r: %d, c: %d, v: %d%n", row, col, map[row][col]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) map[i][j] = 46;
                System.out.print((char)map[i][j]);
            }
            System.out.println();
        }
    }

    static void draw(int[][] map, int row, int col, int direction) {
        if (map[row][col] == 0) map[row][col] = direction;
        else if (map[row][col] != direction) map[row][col] = 43;
    }
}
