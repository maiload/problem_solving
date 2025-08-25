package algorithm.part1.brute_force;

import java.util.Scanner;

public class Main_11068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            if (i != 0) ans.append("\n");
            int num = sc.nextInt();
            boolean B = false;
            for (int j = 2; j < 65; j++) {
                boolean b = false;
                StringBuilder sb = new StringBuilder();
                String numStr = convert(num, j, sb);
//                System.out.println(numStr);
                String[] numArr = numStr.split(",");
                for (int k = 0; k < numArr.length / 2; k++) {
                    if (!numArr[k].equals(numArr[numArr.length - 1 - k])) {
                        b = false;
//                        System.out.printf("b: %b, s: %s, e: %s, r: %d%n", b, numArr[k], numArr[numArr.length - 1 - k], j);
                        break;
                    } else {
                        b = true;
                    }
//                    System.out.printf("b: %b, s: %s, e: %s, r: %d%n", b, numArr[k], numArr[numArr.length - 1 - k], j);
                }
                if (b) {
                    B = true;
                    break;
                }
            }
            if (B) ans.append(1);
            else ans.append(0);
        }
        System.out.println(ans);
    }

    static String convert(int num, int radix, StringBuilder sb) {
        int rest = num % radix;
        sb.append(rest).append(",");
        int value = num / radix;
        if (value == 0) return sb.substring(0, sb.length() - 1);
        return convert(value, radix, sb);
    }
}
