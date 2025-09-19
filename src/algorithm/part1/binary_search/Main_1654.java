package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int l = 1, r = max;
        while (l <= r) {
            int m = (l + r + 1) / 2;
            if (cut(arr, m) >= N) l = m + 1;
            else r = m - 1;
        }
        System.out.println(l - 1);
    }

    static int cut(int[] arr, int m) {
        int count = 0;
        for (int e : arr)
            if (e >= m) count += e / m;
        return count;
    }
}
