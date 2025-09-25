package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int abs = Integer.MAX_VALUE;
        int l = 0, r = N - 1;
        int ansL = 0, ansR = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (abs > Math.abs(sum)) {
                abs = Math.abs(sum);
                ansL = arr[l];
                ansR = arr[r];
            }
            if (sum > 0) r--;
            else if (sum < 0) l++;
            else break;
        }

        System.out.println(sb.append(ansL).append(" ").append(ansR));
    }
}
