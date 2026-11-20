import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			int N = Integer.parseInt(br.readLine());
			int[] dist = new int[N];
			int[] weight = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				dist[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(test_case).append(" ");
			
			
			for (int i = 0; i < N-1; i++) {
				double left = dist[i];
				double right = dist[i+1];
				double mid = 0; 
				
				for (int j = 0; j < 100; j++) {
					mid = (left + right) / 2.0;
					
					double leftForce = 0;
					double rightForce = 0;
					
					for (int k = 0; k <= i ; k++) {
						double d = mid - dist[k];
						leftForce += weight[k] / (d*d);
					}
					
					for (int k = i+1; k < N ; k++) {
						double d = mid - dist[k];
						rightForce += weight[k] / (d*d);
					}
					
					if(leftForce > rightForce) {
						left = mid;
					} else {
						right = mid;
					}
				}
				sb.append(String.format("%.10f ", mid));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}