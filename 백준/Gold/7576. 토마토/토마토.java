import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, M;
    static int[][] box;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Point> q;

    static class Point {
        int x, y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new int[N][M];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    visited[i][j] = 0;
                    q.add(new Point(i,j));
                }
                else if(box[i][j]==-1){
                    visited[i][j]=-1;
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        int result =0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
                    if(visited[nextX][nextY]==0 && box[nextX][nextY]==0) {
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = visited[now.x][now.y] + 1;
                        result = Math.max(result, visited[now.x][now.y] + 1);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && box[i][j]==0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(result);
    }
}
