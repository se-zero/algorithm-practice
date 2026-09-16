import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();

        // 시작점 찾기
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i].charAt(j)=='R'){
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited  = new boolean[n][m];

        queue.offer(new int[]{startX,startY,0});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            if(board[x].charAt(y)=='G') return count;

            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 미끄러지기
                while (nx + dx[i] >= 0 && nx + dx[i] < n &&
                        ny + dy[i] >= 0 && ny + dy[i] < m &&
                        board[nx + dx[i]].charAt(ny + dy[i]) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1;
    }

}