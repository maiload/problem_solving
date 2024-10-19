package algorithm.part5.brute_force.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15663 { // 중복 X, 순서 O
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] seq, selected;
    static boolean[] used;

    static void input() {
        Reader reader = new Reader();
        N = reader.nextInt();
        M = reader.nextInt();
        seq = new int[N + 1];
        used = new boolean[N + 1];
        selected = new int[M + 1];

        for(int i=1; i<=N; i++) seq[i] = reader.nextInt();
        Arrays.sort(seq, 1, N + 1);
    }

    // Recurrence Function
    static void rec_func(int m) {
        if (m == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                if(used[i] || set.contains(seq[i])) continue;
                selected[m] = seq[i];   used[i] = true;
                set.add(seq[i]);
                rec_func(m + 1);
                selected[m] = 0;    used[i] = false;
            }
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