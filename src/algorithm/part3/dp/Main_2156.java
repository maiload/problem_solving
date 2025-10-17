package algorithm.part3.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] quantity = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            quantity[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = quantity[1];
        if (N >= 2) dp[2] = quantity[1] + quantity[2];
        if (N < 3) {
            System.out.println(dp[N]);
            return;
        }

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + quantity[i],
                    Math.max(dp[i - 3] + quantity[i - 1] + quantity[i], dp[i - 1]));
        }
        System.out.println(dp[N]);
    }
}
