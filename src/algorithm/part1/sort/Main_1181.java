package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());  // 20000
        Set<String>[] arr = (Set<String>[]) new HashSet[51];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (arr[str.length()] == null) arr[str.length()] = new HashSet<>();
            arr[str.length()].add(str);
        }

        for (int i = 1; i < 51; i++) {
            if (arr[i] == null) continue;
            List<String> list = new ArrayList<>(arr[i]);
            Collections.sort(list);
            for (String s : list) {
                sb.append(s).append("\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
