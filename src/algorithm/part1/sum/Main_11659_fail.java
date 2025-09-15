package algorithm.part1.sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_fail {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 10만
        int M = Integer.parseInt(st.nextToken());   // 10만
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sIdx = Integer.parseInt(st.nextToken()) - 1;
            int eIdx = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = sIdx; j < eIdx; j++) {
                sum += arr[j];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
