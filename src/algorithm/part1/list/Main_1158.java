package algorithm.part1.list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        sb.append(list.remove(K - 1));

        int idx = K - 1;
        int size = N - 1;
        while (!list.isEmpty()) {
            sb.append(", ");
            idx = (idx + K - 1) % size;
            sb.append(list.remove(idx));
            size--;
        }
        System.out.println(sb.append(">"));
    }
}
