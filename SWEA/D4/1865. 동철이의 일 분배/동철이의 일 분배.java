import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    static int N;
    static double maxProb;
    static boolean[] visited;
    static double[][] prob;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            prob = new double[N][N];
            visited = new boolean[N];
            maxProb = 0.0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    prob[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
                }
            }

            dfs(0, 1.0);
            sb.append(String.format("#%d %.6f\n", test_case, maxProb * 100));
        }
        System.out.print(sb);
    }

    static private void dfs(int worker, double currentProb){
        if(currentProb <= maxProb){
            return;
        }

        if(worker == N){
            maxProb = currentProb;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                if(prob[worker][i] == 0) continue;

                visited[i] = true;
                dfs(worker + 1, currentProb * prob[worker][i]);
                visited[i] = false;
            }

        }
    }

}