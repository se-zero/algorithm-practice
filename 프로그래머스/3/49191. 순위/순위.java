class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        
        // 승패 기록
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        // 플로이드-워셜로 간접 승패 기록 
        for(int k = 1; k < n+1; k++){ 
            for(int i = 1; i < n+1; i++){ 
                for(int j = 1; j < n+1; j++){ 
                    if(i == j) {
                        continue;
                    }
                    
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }
        
        // 정확한 순위 아는 사람 카운트
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int count =0;
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != 0) {
                    count ++;
                }
            }
            
            if(count == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}
