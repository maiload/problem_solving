package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2295_fail {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1000
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = 0;
        loop: for (int i = N - 1; i > 2; i--) {
            int sum = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                int t1 = sum - arr[j];
                int tIdx = find(arr, t1);
                for (int k = tIdx; k >= 0; k--) {
                    int t2 = t1 - arr[k];
                    int idx = Arrays.binarySearch(arr, t2);
                    if (idx >= 0) {
                        answer = arr[i];
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static Integer find(Integer[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int half = (l + r) / 2;
            if (x > arr[half]) l = half + 1;
            else if (x < arr[half]) r = half - 1;
            else return half;
        }
        return r;
    }
}
