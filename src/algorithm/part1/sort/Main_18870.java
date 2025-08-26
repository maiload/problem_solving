package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_18870 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());    // 100만
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] newArr = Arrays.stream(arr).distinct().sorted().toArray();
        for (int i = 0; i < newArr.length; i++) {
            map.put(newArr[i], i);
        }
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i]));
            if (i != N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}
