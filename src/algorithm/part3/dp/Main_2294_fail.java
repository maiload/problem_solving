package algorithm.part3.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_fail {
    static int[] coins;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        int[] dp = new int[N + 1];
        dp[1] = K % coins[0] == 0 ? K / coins[0] : -1;
        for (int i = 1; i < N; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = Math.min(dp[i - 1], calculate(K, i));
            } else {
                dp[i] = calculate(K, i);
            }
        }

        System.out.println(dp[N - 1]);
    }

    static int calculate(int k, int idx) {
        int cnt = 0;
        for (int i = idx - 1; i >= 0; i--) {
            int n = k / coins[i];
            if (n >= 1) {
                k -= n * coins[i];
                cnt += n;
            }
        }

        return k > 0 ? -1 : cnt;
    }
}
