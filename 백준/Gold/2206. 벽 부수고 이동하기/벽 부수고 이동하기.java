import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Point{
        int x,y;
        int dist;
        int broken;
        public Point(int x, int y, int dist, int broken){
            this.x=x;
            this.y=y;
            this.dist = dist;
            this.broken = broken;
        }
    }
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-48;
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList();
        q.add(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                System.out.print(now.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (map[nextX][nextY] == 0) {
                        if (!visited[nextX][nextY][now.broken]) {
                            visited[nextX][nextY][now.broken] = true;
                            q.add(new Point(nextX, nextY, now.dist + 1, now.broken));
                        }
                    } else if (map[nextX][nextY] == 1) {
                        if (now.broken == 0 && !visited[nextX][nextY][1]) {
                            visited[nextX][nextY][1] = true;
                            q.add(new Point(nextX, nextY, now.dist + 1, 1));
                        }

                    }
                }
            }
        }
        System.out.print(-1);
    }
}
