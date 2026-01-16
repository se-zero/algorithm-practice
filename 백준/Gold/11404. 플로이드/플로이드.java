import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] D;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        D = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(D[i], INF);
        }

        for (int i = 0; i < n; i++) {
            D[i][i]=0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            D[a-1][b-1] = Math.min(D[a-1][b-1], c);
        }

        floydWarshall();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(D[i][j]==INF){
                    System.out.print(0 +" " );
                } else {
                    System.out.print(D[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

    static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] != INF && D[k][j] != INF) {
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                    }
                }
            }
        }
    }


}
