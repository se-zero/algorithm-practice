class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0){
                    int size = dfs(i,j,visited, m, n, picture, picture[i][j]);
                    numberOfArea ++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }

            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int dfs(int x, int y, boolean[][] visited, int m, int n, int[][] picture, int color){
        if(visited[x][y] || picture[x][y] != color) return 0;

        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < m && ny >=0 && ny < n){
                if(picture[nx][ny] == color && !visited[nx][ny]){
                    size += dfs(nx, ny, visited, m, n, picture, color);
                }

            }
        }
        return size;
    }
}