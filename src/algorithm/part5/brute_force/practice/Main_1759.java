package algorithm.part5.brute_force.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 { // 중복 X, 순서 X
    static StringBuilder sb = new StringBuilder();
    static int M, N;
    static char[] candi, cypher;
    static final String VOWELS = "aeiou";

    static void input() {
        Reader reader = new Reader();
        M = reader.nextInt();
        N = reader.nextInt();
        candi = new char[N + 1];
        cypher = new char[M + 1];
        for(int i = 1; i<= N; i++) candi[i] = reader.next().charAt(0);
        Arrays.sort(candi, 1, N + 1);
    }

    // Recurrence Function
    static void rec_func(int m, int start, int vCnt, int cCnt) {
        if (m == M + 1) {
            if(vCnt < 1 || cCnt < 2) return;
            for (int i = 1; i <= M; i++) {
                sb.append(cypher[i]);
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= N; i++) {
                cypher[m] = candi[i];

                if (VOWELS.indexOf(candi[i]) >= 0) {
                    rec_func(m + 1, i + 1, vCnt + 1, cCnt);
                } else {
                    rec_func(m + 1, i + 1, vCnt, cCnt + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 1, 0, 0);
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