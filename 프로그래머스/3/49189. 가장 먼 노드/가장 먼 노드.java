import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 생성
        List<Integer>[] graph = new ArrayList[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edges : edge){
            graph[edges[0]].add(edges[1]);
            graph[edges[1]].add(edges[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int answer = 0;

        // 시작점(1번 노드) 큐 삽입 및 방문 처리
        queue.add(1);
        visited[1] = true;

        // BFS
         while(!queue.isEmpty()){
             // 같은 거리 노드 개수
             int num = queue.size();
             
             
             for (int i = 0; i < num; i++) {
                 int cur = queue.poll();
                
                 // 방문 안한 노드 큐에 추가
                 for (int next : graph[cur]){
                     if(!visited[next]){
                         queue.offer(next);
                         visited[next] = true;
                     }
                 }
             }
             
             answer = num;
         }

        return answer;
    }
}