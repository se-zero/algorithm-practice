import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int[][] D;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        D = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(D[i], INF);
        }

        for (int i = 0; i < V; i++) {
            D[i][i]=0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            D[a-1][b-1] = weight;
        }

        floydWarshall();

        int result = INF;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(i==j){
                    continue;
                }
                if (D[i][j] != INF && D[j][i] != INF) {
                    result = Math.min(result, D[i][j] + D[j][i]);
                }
            }
        }
        if(result!=INF){
            System.out.print(result);
        } else {
            System.out.print(-1);
        }

    }

    static void floydWarshall() {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (D[i][k] != INF && D[k][j] != INF) {
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }
        }
    }


}
