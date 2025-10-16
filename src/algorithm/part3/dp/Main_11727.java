package algorithm.part3.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11727 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1000
        // dp[n] = dp[n-1] + 2 * dp[n-2]
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
        }
        System.out.println(dp[N] % 10007);
    }
}
