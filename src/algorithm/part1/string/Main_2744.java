package algorithm.part1.string;

import java.util.Scanner;

public class Main_2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c >= 'a' && c <= 'z'){
                charArray[i] =  Character.toUpperCase(c);
            } else if (c >= 'A' && c <= 'Z') {
                charArray[i] =  Character.toLowerCase(c);
            }
        }
        System.out.println(new String(charArray));
    }
}
