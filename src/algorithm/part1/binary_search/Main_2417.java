package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2417 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()); // 2^63
        long l = 0, r = 1L << 32;
        while (l < r) {
            long m = (l + r) >>> 1;
            if (isBigger(n, m)) r = m;
            else l = m + 1;
        }
        System.out.println(l);
    }

    private static boolean isBigger(long n, long m) {
        return m >= (n - 1) / m + 1;
    }
}
