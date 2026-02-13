import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dp;
    static int[][] height;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        for (int[] D : dp){
            Arrays.fill(D,-1);
        }

        dp[0][0] = dfs(0, 0);

        System.out.println(dp[0][0]);
    }

    static public int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == N - 1 && y == M - 1) {
            return dp[x][y] = 1;
        }

        dp[x][y] =0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (height[nextX][nextY] < height[x][y]) {
                    dp[x][y] += dfs(nextX, nextY);
                }
            }
        }
        return dp[x][y];
    }
}
