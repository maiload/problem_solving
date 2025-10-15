package algorithm.part3.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12851 {   // 1697과 유사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] move = {+1, -1, 2};
        int[] visited = new int[100001];
        int[] cnt = new int[100001];
        Arrays.fill(visited, -1);
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.offer(N);
        visited[N] = 0;
        cnt[N] = 1;

        while (!ad.isEmpty()) {
            int now = ad.poll();
            if (visited[K] != -1 && visited[now] > visited[K]) break;
            for (int i = 0; i < 3; i++) {
                int m = move[i];
                int next = m > 1 ? now*m : now+m;
                if (next < 0 || next > 100000) continue;
                if (visited[next] == -1) { // 첫방문
                    ad.offer(next);
                    visited[next] = visited[now] + 1;
                    cnt[next] = cnt[now];
                } else if (visited[next] == visited[now] + 1) {
                    cnt[next] += cnt[now];
                }
            }
        }

        System.out.println(visited[K]);
        System.out.println(cnt[K]);
    }
}
