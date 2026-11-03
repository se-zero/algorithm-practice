import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int won : money) {
            for(int i = won; i <= n; i++){
                dp[i] = (dp[i] + dp[i-won]) % 1000000007;
            }
        }
        return dp[n];
    }
}