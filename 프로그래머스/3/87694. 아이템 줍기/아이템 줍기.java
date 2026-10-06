import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        boolean[][] visited = new boolean[102][102];
        
        // 상하좌우 탑색 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 직사각형 테두리와 내부 그리기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    
                    // 현재 위치가 테두리인 경우
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (board[i][j] == 0) {
                            board[i][j] = 1;
                        }
                    }
                    //현재 위치가 내부인 경우
                    else {
                        board[i][j] = 2;
                    }
                }
            }
        }

        // 큐에 시작점 넣기
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        // bfs
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            // 도달
            if (cx == itemX * 2 && cy == itemY * 2) {
                return dist/2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx > 0 && nx <= 100 && ny > 0 && ny <= 100) {
                    if(board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny,dist+1});
                    }
                }
            }
        }
        return -1;
    }
}