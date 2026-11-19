import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T= Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			String s = br.readLine();
			String ans = isPalindrome(s)? "YES" : "NO";
			
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	
	static private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		
		String s1 = s.substring(0, s.length()/2);
		String s2 = s.substring(s.length()/2+1);
		if(!isSubPalindrome(s1) || !isSubPalindrome(s2)) {
			return false;
		}
		return true;
	}
	
	static private boolean isSubPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}