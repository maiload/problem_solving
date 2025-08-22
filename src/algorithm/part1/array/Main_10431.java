package algorithm.part1.array;

import java.util.Scanner;

public class Main_10431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[20];
        int row = sc.nextInt();
        int count = 0;
        for (int i = 0; i < row; i++) {
            sb.append(i + 1 + " ");
            sc.nextInt();
            for (int j = 0; j < 20; j++) {
                int student = sc.nextInt();
                arr[j] = student;
                for (int k = j; k > 0 ; k--) {
                    if (arr[k - 1] > arr[k]) {
                        int temp = arr[k - 1];
                        System.out.printf("%d -> %d: %d%n", k + 1, k, temp);
                        arr[k - 1] = arr[k];
                        arr[k] = temp;
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
            count = 0;
        }

        System.out.println(sb);
    }
}
