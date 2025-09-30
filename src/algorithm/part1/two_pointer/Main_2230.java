package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2230 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 10만
        int M = Integer.parseInt(st.nextToken());   // 20억
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int r = 0;
        for (int i = 0; i < N; i++) {
            if (r < i) r = i;
            while (r < N && arr[r] - arr[i] < M) r++;
            if (r == N) break;
            ans = Math.min(ans, arr[r] - arr[i]);
        }

        System.out.println(ans);
    }
}
