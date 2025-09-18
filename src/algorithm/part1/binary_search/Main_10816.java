package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] have = new int[N];    // 50만
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());    // 50만
        st = new StringTokenizer(br.readLine());
        Arrays.sort(have);
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int first = findFirst(have, target);
            int next = findNext(have, target);
            sb.append(next - first).append(" ");
        }
        System.out.println(sb);
    }

    public static int findFirst(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int lowerIdx = arr.length;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (x > arr[m]) l = m + 1;
            else {
                r = m - 1;
                lowerIdx = m;
            }
        }
        return lowerIdx;
    }

    public static int findNext(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        int upperIdx = arr.length;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x >= arr[m]) l = m + 1;
            else {
                r = m - 1;
                upperIdx = m;
            }
        }
        return upperIdx;
    }
}
