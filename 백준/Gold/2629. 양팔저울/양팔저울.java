import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][15001];
        dp[0][0] = true;

        for (int i = 0; i < N; i++) {
            for (int w = 0; w <= 15000; w++) {
                if(dp[i][w]){

                    dp[i+1][w] = true;

                    if(w+weight[i] <= 15000){
                        dp[i+1][w+weight[i]] = true;
                    }

                    int diff = Math.abs(w-weight[i]);
                    dp[i+1][diff] = true;

                }
            }
        }

        int checks = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < checks; i++) {
            int result = Integer.parseInt(st.nextToken());

            if (result > 15000){
                System.out.print("N ");
            } else if (dp[N][result]) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }



    }

}
