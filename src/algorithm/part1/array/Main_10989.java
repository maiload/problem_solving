package algorithm.part1.array;

import java.util.Scanner;

public class Main_10989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(); // 10,000,000
        int[] arr = new int[10001];
        for (int i = 0; i < row; i++) {
            int num = sc.nextInt(); // 1 ~ 10,000
            arr[num] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
