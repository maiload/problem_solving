package algorithm.part3.graph.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_7562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};
        int[][] visited;
        ArrayDeque<Point> ad;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            visited = new int[N][N];
            ad = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point src = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Point dst = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            ad.offer(src);

            while (!ad.isEmpty()) {
                Point now = ad.poll();
                if (now.r == dst.r && now.c == dst.c) {
                    sb.append(visited[now.r][now.c]).append("\n");
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int row = now.r + dr[j];
                    int col = now.c + dc[j];
                    if (row >= 0 && row < N && col >= 0 && col < N && visited[row][col] == 0) {
                        ad.offer(new Point(row, col));
                        visited[row][col] = visited[now.r][now.c] + 1;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
