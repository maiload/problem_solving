package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1302 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String best = "";
        int max = 0;
        int N = Integer.parseInt(br.readLine());    // 1000
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                best = e.getKey();
                max = e.getValue();
            } else if (e.getValue() == max && best.compareTo(e.getKey()) > 0) {
                best = e.getKey();
            }
        }

        System.out.println(best);
    }
}
