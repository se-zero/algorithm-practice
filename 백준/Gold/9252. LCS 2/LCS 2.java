import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st = br.readLine();;
        char[] A = st.toCharArray();

        st = br.readLine();;
        char[] B = st.toCharArray();

        int[][] dp = new int[A.length+1][B.length+1];


        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1]==B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        sb.append(dp[A.length][B.length]).append("\n");

        int i = A.length;
        int j = B.length;
        Stack<Character> stack = new Stack<>();
        while (i > 0 && j > 0) {
            if(A[i-1] == B[j-1]) {
                stack.push(A[i-1]);
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}
