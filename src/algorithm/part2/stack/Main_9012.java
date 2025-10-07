package algorithm.part2.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            ArrayDeque<Integer> ad = new ArrayDeque<>();

            boolean isValid = true;
            for (int j = 0; j < arr.length; j++) {
                char ch = arr[j];
                if (ch == '(') {
                    ad.push(1);
                } else {
                    if (ad.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    ad.pop();
                }
            }

            sb.append(isValid ? ad.isEmpty() ? "YES" : "NO" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
