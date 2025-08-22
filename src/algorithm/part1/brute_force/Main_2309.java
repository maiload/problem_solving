package algorithm.part1.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                int sum = 0;
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j) continue;
                    sum += arr[k];
                }
                if (sum == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
        }

        for (int a : arr) {
            if (a > 0) {
                System.out.println(a);
            }
        }
    }
}
