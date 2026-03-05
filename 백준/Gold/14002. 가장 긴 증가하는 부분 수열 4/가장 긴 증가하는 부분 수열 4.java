import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp,1);

        int[] prev = new int[N];
        Arrays.fill(prev,-1);

        int maxIndex = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(dp[i] > dp[maxIndex]){
                maxIndex = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[maxIndex]).append("\n");

        int cur = maxIndex;
        Stack<Integer> order = new Stack<>();
        while (cur != -1){
            order.push(nums[cur]);
            cur = prev[cur];
        }

        while (!order.isEmpty()){
            sb.append(order.pop()).append(" ");
        }

        System.out.print(sb);
    }

}
