import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int board;
    static int[][] visited;

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Point {
        int x, y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i=0; i<test;i++){
            board = Integer.parseInt(br.readLine());
            visited = new int[board][board];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            bfs(x,y,goalX,goalY);
        }


    }

    public static void bfs(int startX, int startY, int goalX, int goalY) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        visited[startX][startY] = 0;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == goalX && now.y == goalY) {
                System.out.println(visited[now.x][now.y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                
                if(nextX >= 0 && nextX < board && nextY >= 0 && nextY < board && visited[nextX][nextY]==0){
                    q.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                }
            }
        }
    }
}
