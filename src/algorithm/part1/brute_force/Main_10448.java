package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_10448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] t = new int[45];

        for (int i = 1; i < t.length; i++) {
            t[i] = sum(i);
        }
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            boolean b = false;
            for (int j = 1; j < t.length; j++) {
                for (int k = 1; k < t.length; k++) {
                    for (int l = 1; l < t.length; l++) {
                        if (t[j] + t[k] + t[l] == num) {
                            b = true;
                            break;
                        }
                    }
                }
            }
            if (b) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);
    }

    static int sum(int num) {
        return num * (num + 1) / 2;
    }
}
