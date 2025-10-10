package algorithm.part3.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1280 {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < N + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static ArrayDeque<Integer> ad;

    static void bfs(int node) {
        ad = new ArrayDeque<>();
        ad.offer(node);
        visited[node] = true;

        while (!ad.isEmpty()) {
            int now = ad.poll();
            System.out.print(now + " ");
            for (int i = 1; i < N + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    ad.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
