package algorithm.part2.recursive.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14267 {

    static int[] like;
    static int[] parent;
    static List<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        like = new int[N + 1];
        tree = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) continue;
            tree[parent[i]].add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            like[dst] += cost;
        }

        praise(1); // 사장이 1번
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(like[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void praise(int node) {
        for (int child : tree[node]) {
            like[child] += like[node];
            praise(child);
        }
    }
}
