import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		

		for(int test_case = 1; test_case <= 10; test_case++){
			int count = Integer.parseInt(br.readLine());
			
			int[] height = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(height);
			
			for (int i = 0; i < count; i++) {
				height[99]--;
				height[0]++;
				Arrays.sort(height);
			}
			
			sb.append("#").append(test_case).append(" ").append(height[99]-height[0]).append("\n");
		}
		System.out.print(sb);
	}
}