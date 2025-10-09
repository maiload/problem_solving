package algorithm.part2.recursive.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663 {
    static int N;
    static int[] position;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        position = new int[N];
        System.out.println(search(0));
    }

    static int search(int row) {
        // base
        if (row == N) {
            return 1;
        }
        int count = 0;

        // recursive
        for (int col = 0; col < N; col++) {
            if (validate(row, col)) {
                position[row] = col;
                count += search(row + 1);
            }
        }
        return count;
    }

    static boolean validate(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == position[i]) return false;
            if (i + position[i] == row + col) return false;
            if (i - position[i] == row - col) return false;
        }
        return true;
    }
}
