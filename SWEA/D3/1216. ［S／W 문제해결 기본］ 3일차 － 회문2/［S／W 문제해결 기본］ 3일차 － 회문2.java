import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution{
	static char[][] board = new char[100][100];
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine().trim());
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = s.charAt(j);
				}
			}
			
			int maxLen = 1;
			// 가로
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = j; k < 100; k++) {
						int len = k - j + 1;
						if(len <= maxLen) continue;
						
						if(checkRow(i, j, k) || checkCol(i, j, k)) {
							maxLen = len;
						}
					}
				}
				
			}
			
			sb.append("#").append(T).append(" ").append(maxLen).append("\n");
		}
		System.out.print(sb);
	}
	
	static private boolean checkRow(int row, int start, int end) {
		int len = end - start +1;
		for (int i = 0; i < len/2; i++) {
			if(board[row][start+i] != board[row][end-i]) {
				return false;
			}
		}
		return true;
	}
	
	static private boolean checkCol(int col, int start, int end) {
		int len = end - start +1;
		for (int i = 0; i < len/2; i++) {
			if(board[start+i][col] != board[end-i][col]) {
				return false;
			}
		}
		return true;
	}
}

