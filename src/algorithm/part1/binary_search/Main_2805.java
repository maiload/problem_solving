package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 100만
        int M = Integer.parseInt(st.nextToken()); // 20억
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0, r = arr[N - 1];
        while (l < r) {
            int m = (l + r) / 2;
            if (cut(arr, m) >= M) l = m;
            else r = m - 1;
        }
        System.out.println(l);
    }

    static long cut(int[] arr, int m) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > m) sum += (arr[i] - m);
        return sum;
    }
}
