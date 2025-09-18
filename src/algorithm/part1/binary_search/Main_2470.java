package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470 {
    static class Set {
        int minus, plus;

        Set(int mimus, int plus) {
            this.minus = mimus;
            this.plus = plus;
        }

        void compare(int minus, int plus) {
            int curAbs = Math.abs(this.minus + this.plus);
            int newAbs = Math.abs(minus + plus);
            if (curAbs > newAbs) {
                this.minus = minus;
                this.plus = plus;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 10만
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Set set = new Set(arr[0], arr[1]);
        for (int i = 0; i < N; i++) {
            int score = arr[i];
            int find = find(arr, -score);
            if (find == i) continue;
            set.compare(score, arr[find]);
        }
        sb.append(set.minus).append(" ").append(set.plus);
        System.out.println(sb);
    }

    public static int find(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        if (x > arr[r]) return r;
        if (x < arr[l]) return l;
        while (l <= r) {
            int m = (l + r) / 2;
            if (x > arr[m]) l = m + 1;
            else if (x < arr[m]) r = m - 1;
            else return m;
        }
        int left = Math.abs(arr[l] - x);
        int right = Math.abs(arr[r] - x);
        return left > right ? r : l;
    }
}
