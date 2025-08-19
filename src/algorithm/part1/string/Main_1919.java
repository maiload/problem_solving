package algorithm.part1.string;

import java.util.Scanner;


public class Main_1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int count = 0;
        int[] darr1 = str1.chars().distinct().toArray();
        for (int a : darr1) {
            int c1 = str1.indexOf((char) a);
            int c2 = str2.indexOf((char) a);

            System.out.printf("a, c1, c2 : %c, %d, %d\n", a, c1, c2);
            if (c2 == -1) continue;
            count = count + Math.min(c1, c2);
        }
        System.out.println(str1.length() + str2.length() - (2 * count));
    }
}
