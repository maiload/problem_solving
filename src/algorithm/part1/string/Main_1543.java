package algorithm.part1.string;

import java.util.Scanner;

public class Main_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String str = sc.next();
        int count = 0;

        while (input.indexOf(str) != -1) {
            int idx = input.indexOf(str);
            count++;
            input = input.substring(idx + str.length());
        }
        System.out.println(count);
    }
}
