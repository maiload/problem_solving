package algorithm.part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_15652 { // 중복 O, 순서 X
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input() {
        Reader reader = new Reader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];  // 1-based index
    }

    // Recurrence Function
    static void rec_func(int k) {
        if (k == M + 1) {
            IntStream.range(1, M + 1)
                    .forEach(i -> sb.append(selected[i]).append(" "));
            sb.append("\n");
        } else {
            IntStream.range(1, N + 1)
                    .filter(i -> selected[k - 1] <= i)
                    .forEach(i -> {
                        selected[k] = i;
                        rec_func(k + 1);
                        selected[k] = 0;    // backtracking
                    });
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}