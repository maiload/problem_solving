package algorithm.part2.recursive.permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_wrong {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        recFunc(1, M, arr, sb, 0);
        System.out.println(sb);
    }

    static void recFunc(int curDepth, int targetDepth, int[] arr, StringBuilder sb, int curIdx) {
        for (int i = curIdx; i < arr.length; i++) {
            sb.append(arr[i]);
            if (curDepth == targetDepth) {
                sb.append("\n");
                continue;
            } else {
                sb.append(" ");
            }
            recFunc(++curDepth, targetDepth, arr, sb, i + 1);
        }
    }
}
