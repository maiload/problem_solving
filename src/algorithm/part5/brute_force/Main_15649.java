package algorithm.part5.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_15649 { // 중복 X , 순서 O
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

    static void input() {
        Reader reader = new Reader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];  // 1-based index
        used = new int[N + 1];
    }

    // Recurrence Function
    static void rec_func(int k) {
        if (k == M + 1) {
            IntStream.range(1, M + 1)
                    .forEach(i -> sb.append(selected[i]).append(" "));
            sb.append("\n");
        } else {
            IntStream.range(1, N + 1)
                    .filter(i -> used[i] == 0)
                    .forEach(i -> {
                        used[i] = 1;
                        selected[k] = i;
                        rec_func(k + 1);
                        used[i] = 0;    // backtracking
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