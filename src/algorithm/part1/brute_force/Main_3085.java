package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 50
        String[][] map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }
        int ans = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    if (k == 0) {
                        if (j + 1 == N) continue;
                        System.out.printf("i: %d, j: %d, k: %d%n", i, j, k);
                        String temp = map[i][j + 1];
                        map[i][j + 1] = map[i][j];
                        map[i][j] = temp;
                        int r = rowMaxCount(map);
                        int c = colMaxCount(map);
                        ans = Math.max(ans, Math.max(r, c));
                        map[i][j] = map[i][j + 1];
                        map[i][j + 1] = temp;
                    } else {
                        if (i + 1 == N) continue;
                        String temp = map[i + 1][j];
                        map[i + 1][j] = map[i][j];
                        map[i][j] = temp;
                        int r = rowMaxCount(map);
                        int c = colMaxCount(map);
                        ans = Math.max(ans, Math.max(r, c));
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = temp;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static int rowMaxCount(String[][] arr) {
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr[i].length - 1; j++) {
                String left = arr[i][j];
                String right = arr[i][j + 1];
                if (left.equals(right)) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static int colMaxCount(String[][] arr) {
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr[i].length - 1; j++) {
                String up = arr[j][i];
                String down = arr[j + 1][i];
                if (up.equals(down)) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
