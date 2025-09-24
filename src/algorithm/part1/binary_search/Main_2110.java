package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        int minLength = 1;
        int maxLength = (max - min) / (C - 1) + 1;
        while (minLength < maxLength) {
            System.out.printf("left: %d, right: %d, ", minLength, maxLength);
            int m = (minLength + maxLength) >>> 1;
            if (count(arr, m) < C) maxLength = m;
            else minLength = m + 1;
        }
        System.out.println(minLength - 1);
    }

    static int count(int[] arr, int m) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[idx] < m) continue;
            count++;
            idx = i;
        }
        System.out.printf("m: %d, count: %d%n", m, count);
        return count;
    }
}
