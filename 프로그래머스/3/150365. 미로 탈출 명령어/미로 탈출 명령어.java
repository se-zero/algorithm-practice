import java.util.*;

class Solution {
    // 방향 배열(알파벳 사전순)
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] dir = {"d", "l", "r", "u"};
    
    String answer = "";
    int n,m;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        
        //최단 거리 계산
        int diff = Math.abs(x-r) + Math.abs(y-c);
        
        // 애초에 도달 불가능한 경우 미리 차단
        if(diff > k || (k - diff) % 2 != 0){
            return "impossible";
        } 
        
        // 탐색
        dfs(x, y, r, c, k, "", 0);
        
        // 결과
        if(answer.equals("")){
            return "impossible";
        } else {
            return answer;
        }
            
    }
    
    private void dfs(int x, int y, int r, int c, int k, String path, int count){
        // 이미 정답이 있다면 종료
        if (!answer.equals("")) return;
        
        // 남은 거리와 남은 횟수 계산해, 불가능한 길이면 포기
        int remainDist = Math.abs(x-r) + Math.abs(y-c);
        int remainCount = k - count;
        if(remainDist > remainCount || (remainCount - remainDist)%2 != 0) return;
        
        // K번 이동, 목적지면 기록후 종료
        if (count == k && x == r && y == c) {
            answer = path;
            return;
        }
        
        // 사전순 탐색
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx > 0 && nx <= n && ny > 0 && ny <= m){
                dfs(nx, ny, r, c, k, path + dir[i], count+1);
            }
        }
        
        
    }
}