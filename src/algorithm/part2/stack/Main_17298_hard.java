package algorithm.part2.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17298_hard {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];
        Arrays.fill(ans, -1);

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!ad.isEmpty() && arr[ad.peek()] < arr[i]) {
                ans[ad.pop()] = arr[i];
            }
            ad.push(i);
        }

        for (int i = 0; i < N; i++) {
            if (i != 0) sb.append(" ");
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }
}
