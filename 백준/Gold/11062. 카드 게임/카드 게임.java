import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] card = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            int[] ps = new int[N+1];
            ps[0] = 0;
            for (int i = 0; i < N; i++) {
                ps[i+1] = ps[i] + card[i];
            }

            int[][] dp = new int[N][N];

            for (int len = 1; len <= N; len++) {
                for (int i = 0; i + len - 1 < N; i++) {
                    int j = i + len - 1;

                    if (i == j) {
                        dp[i][j] = card[i];
                    } else {
                        int left = card[i] + (ps[j + 1] - ps[i+1] - dp[i+1][j]);
                        int right = card[j] + (ps[j] - ps[i] - dp[i][j-1]);
                        dp[i][j] = Math.max(left, right);
                    }
                }
            }


            sb.append(dp[0][N - 1]).append('\n');
        }

        System.out.print(sb.toString());
    }

}
