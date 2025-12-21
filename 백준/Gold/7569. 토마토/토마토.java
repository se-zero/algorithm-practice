import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, M, H;
    static int[][][] box;
    static int[][][] visited;

    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<Point> q;

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visited = new int[H][N][M];
        q = new LinkedList<>();
        for(int k = 0; k <H; k++){
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    box[k][i][j] = Integer.parseInt(st.nextToken());
                    if(box[k][i][j]==1){
                        visited[k][i][j] = 0;
                        q.add(new Point(i,j,k));
                    }
                    else if(box[k][i][j]==-1){
                        visited[k][i][j]=-1;
                    }
                }
            }
        }


        bfs();
    }

    public static void bfs() {
        int result =0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                int nextZ = now.z + dz[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >=0 && nextZ < H){
                    if(visited[nextZ][nextX][nextY]==0 && box[nextZ][nextX][nextY]==0) {
                        q.add(new Point(nextX, nextY, nextZ));
                        visited[nextZ][nextX][nextY] = visited[now.z][now.x][now.y] + 1;
                        result = Math.max(result, visited[now.z][now.x][now.y] + 1);
                    }
                }
            }
        }
        for(int k =0; k < H; k++){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[k][i][j] == 0 && box[k][i][j]==0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
