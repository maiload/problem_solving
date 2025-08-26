package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_10814 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<String>[] arr = new ArrayList[201];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken()); // 200
            String name = st.nextToken();
            if (arr[age] == null) arr[age] = new ArrayList<>();
            arr[age].add(name);
        }

        for (int i = 1; i < 201; i++) {
            if (arr[i] == null) continue;
            for (String s : arr[i]) {
                sb.append(i).append(" ").append(s).append("\n");
            }
        }

        System.out.println(sb);
    }
}
