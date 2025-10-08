package algorithm.part2.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656 {
    static int N;
    static int M;
    static int[] arr;
    static int[] output;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
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
        recFunc(0);
        System.out.println(sb);
    }

    static void recFunc(int depth) {
        // base
        if (depth == M) {

            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        // recursive
        for (int i = 0; i < N; i++) {
            output[depth] = arr[i];
            recFunc(depth + 1);
        }
    }
}
