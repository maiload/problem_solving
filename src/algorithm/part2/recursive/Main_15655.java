package algorithm.part2.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655 {
    static int N;
    static int M;
    static int[] arr;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        recFunc(0, 0);
    }

    static void recFunc(int depth, int startIdx) {
        // base
        if (depth == M) {
            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        // recursive
        for (int i = startIdx; i < N; i++) {
            output[depth] = arr[i];
            recFunc(depth + 1, i + 1);
        }
    }
}
