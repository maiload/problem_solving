package algorithm.part2.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {
    static int n, m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        check = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        recFunc(0);
    }

    static void recFunc(int depth) {
        // base case
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        // recursive case
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = numbers[i];
                recFunc(depth + 1);
                check[i] = false;
            }
        }
    }
}
