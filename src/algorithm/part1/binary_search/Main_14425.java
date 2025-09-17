package algorithm.part1.binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] nArr = new String[N];
        for (int i = 0; i < N; i++) {
            nArr[i] = br.readLine();
        }
        int answer = 0;
        Arrays.sort(nArr);
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            int idx = Arrays.binarySearch(nArr, str);
            if (idx >= 0) answer++;
        }
        System.out.println(answer);
    }
}
