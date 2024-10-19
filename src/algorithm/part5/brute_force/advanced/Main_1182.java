package algorithm.part5.brute_force.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {
    static int N, S, cnt;
    static int[] group;

    static void input() {
        Reader reader = new Reader();
        N = reader.nextInt();
        S = reader.nextInt();
        group = new int[N + 1]; // 1-based index
        for (int i = 1; i <= N; i++) {
            group[i] = reader.nextInt();
        }
    }

    // Recurrence Function
    static void rec_func(int index, int sum) {
        if (index == N + 1) {
            if(sum == S) cnt++;
        }else{
            rec_func(index + 1, sum + group[index]);
            rec_func(index + 1, sum);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
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