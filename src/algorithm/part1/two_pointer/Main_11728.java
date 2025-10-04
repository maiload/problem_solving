package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11728 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N];
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        int r = 0;
        for (int i = 0; i < N; i++) {
            while (r < M && arrA[i] > arrB[r]) {
                sb.append(arrB[r]).append(" ");
                r++;
            }
            sb.append(arrA[i]).append(" ");
        }
        while (r < M) {
            sb.append(arrB[r++]).append(" ");
        }
        System.out.println(sb);
    }
}
