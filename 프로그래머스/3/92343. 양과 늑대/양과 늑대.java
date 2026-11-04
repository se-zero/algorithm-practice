import java.util.*;

class Solution {
    // 현재 상태 클래스
    class State {
        int sheep;
        int wolf;
        List<Integer> nextNodes;
        
        public State(int sheep, int wolf, List<Integer> nextNodes){
            this.sheep=sheep;
            this.wolf=wolf;
            this.nextNodes=nextNodes;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        List<Integer>[] graph = new ArrayList[info.length];
        for(int i=0; i<info.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 그래프 생성
        for(int i=0; i< edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
        }
        
        
        Queue<State> q = new LinkedList<>(); 
        q.offer(new State(1,0,new ArrayList<>(graph[0])));
        
        int maxSheep = 0;
        while(!q.isEmpty()) {
            State current = q.poll();
            
            maxSheep = Math.max(maxSheep, current.sheep);
            
            for(int nextNode : current.nextNodes) {
                int nextSheep = current.sheep + (info[nextNode] == 0 ? 1:0);
                int nextwolf = current.wolf + (info[nextNode] == 1 ? 1:0);
                
                if(nextSheep > nextwolf) {
                    List<Integer> nextNodeList = new ArrayList<>(current.nextNodes);
                    nextNodeList.remove(Integer.valueOf(nextNode));
                    nextNodeList.addAll(graph[nextNode]);
                    
                    q.offer(new State(nextSheep, nextwolf, nextNodeList));
                }
            }
        }
        return maxSheep;
    }
}