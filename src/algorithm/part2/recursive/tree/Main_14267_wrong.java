package algorithm.part2.recursive.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14267_wrong {
    static class Node {
        int node;   // 칭찬 받은 사람
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int[] score;
    static List<Node>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] parent = new int[N + 1];
        score = new int[N + 1];
        graph = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[parent[dst]].add(new Node(dst, cost));
        }

        praise(1, 0); // 대표가 1번
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            sb.append(score[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void praise(int from, int cost) {
        if (from < graph.length - 1 && graph[from].isEmpty()) {
            score[from + 1] += cost;
            praise(from + 1, cost);
            return;
        }
        // recursive
        for (int i = 0; i < graph[from].size(); i++) {
            Node to = graph[from].get(i);
            System.out.printf("from: %d, to: %d, cost: %d%n", from, to.node, cost + to.cost);
            score[to.node] += cost + to.cost;
            praise(to.node, cost + to.cost);
        }
    }
}
