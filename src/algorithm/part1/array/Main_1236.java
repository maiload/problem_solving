package algorithm.part1.array;

import java.util.Scanner;

public class Main_1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(); // 50
        int col = sc.nextInt(); // 50
        boolean[] rowArr = new boolean[row];
        boolean[] colArr = new boolean[col];
        int rowCount = 0;
        int colCount = 0;

        for (int i = 0; i < row; i++) {
            String str = sc.next();
            if (str.indexOf('X') == -1) continue;
            rowArr[i] = true;
            for (int j = 0; j < col; j++) {
                if (str.charAt(j) == 'X') colArr[j] = true;
            }
        }

        for (boolean b : rowArr) {
            if (!b) rowCount++;
        }
        for (boolean b : colArr) {
            if (!b) colCount++;
        }

        System.out.println(Math.max(rowCount, colCount));
    }
}
