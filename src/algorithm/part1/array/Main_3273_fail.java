package algorithm.part1.array;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3273_fail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seq = sc.nextInt();
        int arr[] = new int[seq];
        for (int i = 0; i < seq; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(arr);
        int end = seq - 1;
        int count = 0;

        for (int i = 0; i < seq / 2; i++) {
            int a = arr[i];
            for (int j = end; j > i; j--) {
                if (a + arr[j] > x) {
                    if ((j - 1) > i) end--;
                } else if (a + arr[j] == x) {
                    count++;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
