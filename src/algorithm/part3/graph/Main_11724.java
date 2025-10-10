package algorithm.part3.graph;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_11724 {
    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
//                dfsRecursion(i);
//                dfsStack(i);
                bfsQueue(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfsRecursion(int node) {
        visited[node] = true;
        for (int i = 0; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }

    static void dfsStack(int node) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.push(node);
        visited[node] = true;

        while (!ad.isEmpty()) {
            int now = ad.pop();
            for (int i = 1; i < n + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    ad.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void bfsQueue(int node) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(node);
        visited[node] = true;

        while (!ad.isEmpty()) {
            int now = ad.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    ad.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
