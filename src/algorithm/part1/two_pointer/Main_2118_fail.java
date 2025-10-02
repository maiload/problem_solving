package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2118_fail {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(br.readLine());
            arr[i] = sum;
        }
        int ans = 0;
        int r = 0;
        for (int i = 0; i < N - 1; i++) {
            while (r < N && arr[r] - arr[i] < sum / 2) r++;
            if (r == N) r = N - 1;
            int max = arr[r] - arr[i];
            System.out.printf("max: %d, l: %d, r: %d%n", max, i, r);
            ans = Math.max(ans, Math.min(max, sum - max));
        }
        System.out.println(ans);
    }
}
