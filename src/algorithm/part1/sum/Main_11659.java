package algorithm.part1.sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 10만
        int M = Integer.parseInt(st.nextToken());   // 10만
        st = new StringTokenizer(br.readLine());
        int[] acc = new int[N + 1];
        acc[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sIdx = Integer.parseInt(st.nextToken());
            int eIdx = Integer.parseInt(st.nextToken());
            int sum = acc[eIdx] - acc[sIdx - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
