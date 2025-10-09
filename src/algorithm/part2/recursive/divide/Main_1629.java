package algorithm.part2.recursive.divide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {
    static int A, B, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(power(A, B));
    }

    static long power(long a, long b) {
        // base
        if (b == 1) return a % C;

        // recursive
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % C;
        } else {
            return (((half * half) % C) * a) % C;
        }
    }
}
