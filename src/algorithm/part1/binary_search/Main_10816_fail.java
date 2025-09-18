package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816_fail {
    public static void main(String[] args) throws Exception{
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
            int count = find(have, target, 0, have.length - 1);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    public static int find(int[] arr, int x, int left, int right) {
        int count = 0;
        while (left <= right) {
            int m = (left + right) / 2;
            if (x > arr[m]) left = m + 1;
            else if (x < arr[m]) right = m - 1;
            else {
                count++;
                count += find(arr, x, left, m - 1);
                count += find(arr, x, m + 1, right);
                return count;
            }
        }
        return count;
    }
}
