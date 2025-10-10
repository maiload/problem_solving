package algorithm.part3.dp;

import java.util.Scanner;

public class Main_2748 {
    static long[] dp = new long[95];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo2(n));
    }

    static long fibo1(int n) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static long fibo2(int n) {
        dp[1] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i + 1] += dp[i];
            dp[i + 2] += dp[i];
        }
        return dp[n];
    }
}
