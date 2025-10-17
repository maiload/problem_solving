package algorithm.part3.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294 {
    static int[] coins;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 100
        int K = Integer.parseInt(st.nextToken());   // 10000
        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        final int INF = Integer.MAX_VALUE;

        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            if (coin > K) continue;
            for (int v = coin; v <= K; v++) {
                if (dp[v - coin] != INF) {
                    dp[v] = Math.min(dp[v], dp[v - coin] + 1);
                    System.out.printf("K: %d, COIN: %d, dp[k]: %d%n", v, coin, dp[v]);
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
