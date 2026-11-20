import java.util.Scanner;
import java.io.FileInputStream;


class Solution{
	public static void main(String args[]) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[] dp = new int[L+1];
			
			for (int i = 0; i < N; i++) {
				int score = sc.nextInt();
				int cal = sc.nextInt();
				
				for (int j = L; j >= cal; j--) {
					dp[j] = Math.max(dp[j], dp[j-cal] + score);
				}
			}
			sb.append("#").append(test_case).append(" ").append(dp[L]).append("\n");
		}
		System.out.print(sb);
	}
}