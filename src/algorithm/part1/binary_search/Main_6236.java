package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6236 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int l = max, r = sum;   // 최소, 폐구간
        while (l <= r) {
            int m = (l + r) / 2;
            if (count(arr, m) > M) l = m + 1;
            else r = m - 1;
        }
        System.out.println(l);
    }

    static int count(int[] arr, int m) {
        int count = 1;
        int cur = m;
        for (int money : arr) {
            if (money > cur) {
                count++;
                cur = m;
            }
            cur -= money;
        }

        return count;
    }
}
