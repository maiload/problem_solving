package algorithm.part2.recursive.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int R;
    static int C;
    static int[][] board;
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        check = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = arr[j] - 'A';
            }
        }

        System.out.println(search(0, 0));
    }

    static int search(int row, int col) {
        // base
        check[board[row][col]] = true;
        int count = 0;

        // recursive
        for (int i = 0; i < 4; i++) {
            int nextR = row + dr[i];
            int nextC = col + dc[i];
            if(validate(nextR, nextC) && !check[board[nextR][nextC]]) {
                int result = search(nextR, nextC);
                count = Math.max(count, result);
            }
        }
        check[board[row][col]] = false;
        return count + 1;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < R && col < C;
    }
}
