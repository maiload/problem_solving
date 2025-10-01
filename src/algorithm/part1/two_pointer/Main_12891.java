package algorithm.part1.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // 100만
        int P = Integer.parseInt(st.nextToken());   // 100만
        String str = br.readLine();
        char[] arr = str.toCharArray();
        st = new StringTokenizer(br.readLine());    // A, C, G, T
        int[] dna = new int[4];
        for (int i = 0; i < 4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int[] count = new int[128];
        for (int i = 0; i < P - 1; i++) {
            count[arr[i]]++;
        }
        for (int i = P - 1; i < S; i++) {
            count[arr[i]]++;
            if (compare(dna, count)) ans++;
            count[arr[i - P + 1]]--;
        }
        System.out.println(ans);
    }

    static boolean compare(int[] dna, int[] count) {
        return dna[0] <= count['A'] &&
                dna[1] <= count['C'] &&
                dna[2] <= count['G'] &&
                dna[3] <= count['T'];
    }
}
