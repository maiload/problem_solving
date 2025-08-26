package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2910 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 1000
        int C = Integer.parseInt(st.nextToken());   // 10억
        st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> order = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String num = st.nextToken();
            map.put(num, map.getOrDefault(num, 0) + 1);
            order.putIfAbsent(num, i);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp == 0) {
                return order.get(a.getKey()) - order.get(b.getKey());
            }
            return cmp;
        });
        for (Map.Entry<String, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey()).append(" ");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
