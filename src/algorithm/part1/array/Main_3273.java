package algorithm.part1.array;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seq = sc.nextInt();
        int arr[] = new int[seq];
        for (int i = 0; i < seq; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(arr);
        int count = 0;

        int left = 0;
        int right = seq - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }

        System.out.println(count);
    }
}
