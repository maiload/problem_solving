package algorithm.part2.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_4949 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (".".equals(str)) break;

            char[] arr = str.toCharArray();
            ArrayDeque<Character> ad = new ArrayDeque<>();
            boolean isValid = true;
            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];
                if (ch == '(' || ch == '[') {
                    ad.push(ch);
                } else if (ch == ')' || ch == ']') {
                    if (ad.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char pop = ad.pop();
                    if ((pop == '(' && ch == ']') || (pop == '[' && ch == ')')) {
                        isValid = false;
                        break;
                    }
                }
            }
            if (!ad.isEmpty()) isValid = false;
            sb.append(isValid ? "yes" : "no").append("\n");
        }
        System.out.println(sb);
    }
}
