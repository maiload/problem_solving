package algorithm.part2.recursive.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725 {
    static List<Integer>[] tree;
    static int[] parent;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        parent = new int[N + 1];
        check = new boolean[N + 1];

        find(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < N + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void find(int node) {
        // base
//        if (check[node]) return;  // recursive에서 검사하기 때문에 중복 처리 X
        check[node] = true;
        // recursive
        for (int i = 0; i < tree[node].size(); i++) {
            int next = tree[node].get(i);
            if (!check[next]) {
                parent[next] = node;
                find(next);
            }
        }
    }
}
