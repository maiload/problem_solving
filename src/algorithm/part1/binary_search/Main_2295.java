package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_2295 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1000
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        int answer = 0;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int sub = arr[i] - arr[j];
                if (set.contains(sub)) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }
        System.out.println(answer);
    }
}
