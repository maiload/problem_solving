package algorithm.part3.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] move = {1, -1, 2};
        int[] visited = new int[100001];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(N);
        while (!ad.isEmpty()) {
            int now = ad.poll();
            if (now == K) break;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = move[i] * now;
                } else {
                    next = move[i] + now;
                }
                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    ad.offer(next);
                }
            }
        }

        System.out.println(visited[K]);
    }
}
