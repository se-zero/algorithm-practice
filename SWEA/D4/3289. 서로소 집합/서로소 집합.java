import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


class Solution{
	static int[] parent;
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++){
			StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
			
			// 배열 초기화
            parent = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				parent[i] = i;
			}
			
			sb.append("#").append(test_case).append(" ");
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
				
				if(cal == 0) {
					union(a,b);
				} else {
					if(find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
            if (rootA < rootB) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB; 
            }
		}
	}
	
	static int find(int x) {
		if (parent[x] == x) {
            return x;
        }
		
		return parent[x] = find(parent[x]);
	}
	
}