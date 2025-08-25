package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int radix = sc.nextInt();
        String ans = convert(N, radix, sb);
        System.out.println(ans);
    }

    static String convert(int num, int radix, StringBuilder sb) {
        int rest = num % radix;
        if (rest >= 10) {
            char c = (char)('A' + (rest - 10));
            sb.append(c);
        } else {
            sb.append(rest);
        }
        int value = num / radix;
        if (value == 0) return sb.reverse().toString();
        return convert(value, radix, sb);
    }
}
