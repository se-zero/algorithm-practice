import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dist;
    static int[][] next;
    static int n,m;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        next = new int[n][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(dist[a-1][b-1] > c){
                dist[a-1][b-1] = c;
                next[a-1][b-1] = b-1;
            }
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dist[i][j] == INF) sb.append(0).append(" ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j || dist[i][j] == INF){
                    sb.append(0).append("\n");
                    continue;
                }

                List<Integer> path = getPath(i,j);
                sb.append(path.size()).append(" ");
                for (int p : path){
                    sb.append(p+1).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static public void floydWarshall(){
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        if(dist[i][j] > dist[i][k] + dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }
    }

    static public List<Integer> getPath(int i, int j){
        List<Integer> path = new ArrayList<>();

        int cur = i;
        path.add(cur);

        while(cur != j){
            cur = next[cur][j];
            path.add(cur);
        }

        return path;
    }

}
