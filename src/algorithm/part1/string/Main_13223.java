package algorithm.part1.string;

import java.util.Scanner;

public class Main_13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t1 = sc.next();
        String t2 = sc.next();
        String[] arr1 = t1.split(":");
        String[] arr2 = t2.split(":");
        boolean b = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            int a2 = Integer.parseInt(arr2[i]);
            int a1 = Integer.parseInt(arr1[i]);
            if (b)  a2--;
            if (a2 < a1) {
                b = true;
                if (i == 0) {
                    a2 = a2 + 24;
                } else {
                    a2 = a2 + 60;
                }
            } else {
                b = false;
            }
            String sub = String.valueOf(a2 - a1);
            sb.insert(0, sub);
            if (sub.length() == 1) sb.insert(0, "0");
            if (i != 0) sb.insert(0, ":");
        }
        System.out.println(sb);
    }
}
