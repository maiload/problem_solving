package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 10만
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = N + 1;
        int r = 0;
        int sum = arr[0];
        for (int i = 0; i < N; i++) {
            while (sum < C && r < N - 1) {
                sum += arr[++r];
            }
            if (sum >= C) ans = Math.min(ans, r - i + 1);
            sum -= arr[i];
        }
        System.out.println(ans == N + 1 ? 0 : ans);
    }
}
