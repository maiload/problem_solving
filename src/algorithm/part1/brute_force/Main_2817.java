package algorithm.part1.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();   // 250만
        int N = sc.nextInt();   // 10
        char[] names = new char[N];
        double[][] scores = new double[N][14];
        int[] chips = new int[N];
        for (int i = 0; i < N; i++) {
            char name = sc.next().charAt(0);
            int poll = sc.nextInt();
            if (poll < X * (0.05)) {
                chips[name - 'A'] = -1;
                continue;
            }
            names[i] = name;
            double[] score = new double[14];
            for (int j = 0; j < 14; j++) {
                score[j] = (double)poll / (j + 1);
            }
            Arrays.sort(score);
            scores[i] = score;
        }

        for (int i = 0; i < 14; i++) {
            int idx = 0;
            double max = 0;
            for (int j = 0; j < N; j++) {
                double score = getScore(scores[j], scores[j].length - 1);
                max = Math.max(max, score);
                if (Double.compare(max, score) == 0) {
                    idx = j;
                }
//                System.out.printf("i: %d, j: %d, score: %f, max: %f, idx: %d%n", i, j, score, max, idx);
            }
//            System.out.println(names[idx]);
            setScore(scores[idx]);
            chips[names[idx] - 'A'] += 1;
        }

        for (int i = 0; i < chips.length; i++) {
            if (chips[i] == -1) continue;
            System.out.printf("%c %d%n", (char) (i + 'A'), chips[i]);
        }
    }

    static double getScore(double[] score, int idx) {
        if (score[idx] == 0) {
            return getScore(score, --idx);
        } else {
            return score[idx];
        }
    }

    static void setScore(double[] score) {
        for (int i = score.length - 1; i >= 0; i--) {
            if (score[i] != 0) {
                score[i] = 0;
                break;
            }
        }
    }
}
