import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class matrix{
        int a,b;

        matrix(int a, int b){
            this.a=a;
            this.b=b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        matrix[] matrices = new matrix[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            matrices[i] = new matrix(a,b);
        }
        
        long[][] dp = new long[N+1][N+1];

        for (int len = 2; len <= N ; len++) {
            for (int i = 1; i + len -1 <= N; i++) {
                int j = i + len -1;
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+(long)matrices[i].a*matrices[k].b*matrices[j].b);
                }

            }
        }

        System.out.println(dp[1][N]);


    }
}
