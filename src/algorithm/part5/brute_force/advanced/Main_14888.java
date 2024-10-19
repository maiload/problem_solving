package algorithm.part5.brute_force.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main_14888 {
    static StringBuilder sb = new StringBuilder();
    static int N, max, min, value;
    static int[] operands, operators;

    static void input() {
        Reader reader = new Reader();
        N = reader.nextInt();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        operands = new int[N + 1];
        operators = new int[5];
        IntStream.range(1, N + 1).forEach(i -> operands[i] = reader.nextInt());
        IntStream.range(1, 5).forEach(i -> operators[i] = reader.nextInt());
        value = operands[1];
    }

    static int calculate(int value, int operator, int operand) {
        if (operator == 1) {
            return value + operand;
        } else if (operator == 2) {
            return value - operand;
        } else if (operator == 3) {
            return value * operand;
        } else {
            return value / operand;
        }
    }

    // Recurrence Function
    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            IntStream.range(1, 5)
                    .filter(i -> operators[i] > 0)
                    .forEach(i -> {
                        operators[i]--;
                        rec_func(k + 1, calculate(value, i, operands[k + 1]));
                        operators[i]++;
                    });
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, operands[1]);
        sb.append(max).append("\n").append(min);
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