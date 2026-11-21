import java.util.Scanner;

class Solution{
	static int count;
	static int N;
	
	public static void main(String args[]) throws Exception	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			boolean[][] board = new boolean[N][N];
			
			count = 0;
			dfs(board, 0);
			
			System.out.println("#" + test_case + " " + count);
		}
	}
	
	static void dfs(boolean[][] board, int row) {
		if(row == N) {
			count++;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			board[row][col] = true;
			if(check(board, row, col)) {
				dfs(board, row+1);
			}
			board[row][col] = false;
			
		}
	}
	
	static boolean check(boolean[][] board, int row, int col) {
		for (int i = row-1; i >= 0; i--) {
			if(board[i][col]) {
				return false;
			}
		}
		
		int leftCol = col;
		int rightCol = col;
		for (int i = row-1; i >= 0; i--) {
			leftCol--;
			rightCol++;
			
			if(leftCol >= 0 && board[i][leftCol]) {
				return false;
			}
			
			if(rightCol < N && board[i][rightCol]) {
				return false;
			}
		}
		return true;
	}
}