package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 10만
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
//            int idx = Arrays.binarySearch(arr, x);
            int idx = isExist(arr, x);
            sb.append(idx >= 0 ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    public static int isExist(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (r >= l) {
            int half = (l + r) / 2;
            if (arr[half] > x) r = half - 1;
            else if (arr[half] < x) l = half + 1;
            else return half;
        }
        return -1;
    }
}
