import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, W;
    static int[][] event;
    static int[][] dp;
    static int[][] choice;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        dp = new int[W+1][W+1];
        choice = new int[W + 1][W + 1];

        for (int i = 0; i <= W; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        event = new int[W+1][2];
        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            event[i][0] = Integer.parseInt(st.nextToken());
            event[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = solve(0,0);
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        trace(0,0, sb);

        System.out.println(sb);

    }

    static int solve(int i, int j) {
        int next = Math.max(i,j) + 1;
        if (next > W) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int car1x, car1y;
        if (i == 0) {
            car1x = 1;
            car1y = 1;
        } else {
            car1x = event[i][0];
            car1y = event[i][1];
        }

        int car2x, car2y;
        if (j == 0) {
            car2x = N;
            car2y = N;
        } else {
            car2x = event[j][0];
            car2y = event[j][1];
        }

        int nextX = event[next][0];
        int nextY = event[next][1];

        int cost1 = dist(car1x, car1y, nextX, nextY) + solve(next, j);
        int cost2 = dist(car2x, car2y, nextX, nextY) + solve(i, next);

        if(cost1<=cost2){
            dp[i][j] = cost1;
            choice[i][j] = 1;
        } else {
            dp[i][j] = cost2;
            choice[i][j] = 2;
        }

        return dp[i][j];
    }

    static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    static void trace(int i, int j, StringBuilder sb) {
        int next = Math.max(i, j) + 1;
        if (next > W) return;

        if (choice[i][j] == 1) {
            sb.append(1).append("\n");
            trace(next, j, sb);
        } else {
            sb.append(2).append("\n");
            trace(i, next, sb);
        }
    }



}
