import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution{
	static int maxNum;
	static int totalCount;
	static Set<String>[] visited;
	
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			char[] arr = sc.next().toCharArray();
			totalCount = sc.nextInt();
			
			maxNum = 0;
			visited = new HashSet[totalCount + 1];
			for (int i = 0; i <= totalCount; i++) {
                visited[i] = new HashSet<>();
            }
			
			dfs(arr,0);
			System.out.println("#" + test_case + " " + maxNum);
		}
		
	}
	
	static void dfs(char[] arr, int depth) {
		String current = String.valueOf(arr);
		
		if(visited[depth].contains(current)) {
			return;
		}
		visited[depth].add(current);
		
		if(depth == totalCount) {
			maxNum = Math.max(maxNum, Integer.parseInt(current));
			return;
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				swap(arr,i,j);
				dfs(arr,depth+1);
				swap(arr,i,j);
			}
		}
	}
	
	static void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}