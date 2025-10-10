package algorithm.part3.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2178 {
    static int N;
    static int M;
    static int[][] maze;
    static int[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                maze[i][j] = str.charAt(j - 1) - '0';
            }
        }

        ArrayDeque<Point> ad = new ArrayDeque<>();
        ad.offer(new Point(1, 1));
        visited[1][1] = 1;
        while (!ad.isEmpty()) {
            Point now = ad.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nc < 1 || nc > M || nr < 1 || nr > N) continue;
                if (visited[nr][nc] == 0 && maze[nr][nc] == 1) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    ad.offer(new Point(nr, nc));
                }
            }
        }

        System.out.println(visited[N][M]);
    }

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
