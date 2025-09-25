package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // N
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = arr[0];
        int r = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            while (sum < M && r < N - 1) {
                sum += arr[++r];
            }
            if (sum == M) ans++;
            sum -= arr[i];
        }
        System.out.println(ans);
    }
}
