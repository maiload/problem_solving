package algorithm.part1.string;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] arr = input.toUpperCase().toCharArray();
        Arrays.sort(arr);
        int max = 1, count = 1;
        char ch = arr[0];
        boolean b = false;
        System.out.println(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
                if (i == arr.length - 1) {
                    if (count > max) {
                        max = count;
                        ch = arr[arr.length - 1];
                        count = 0;
                    }
                }
            } else {
                if (count > max) {
                    max = count;
                    ch = arr[i - 1];
                }
                count = 1;
            }
            if (count == max) {
                b = true;
            } else {
                b = false;
            }
            System.out.printf("arr[i]: %c, ch : %s, count: %d, max: %d, b: %b\n", arr[i], ch, count, max, b);
        }
        char ans = b ? '?' : ch;
        System.out.println(ans);
    }
}
