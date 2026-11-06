import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 병사 소모를 내림차순으로 저장
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        
        int count =0;
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            q.offer(enemy[i]);
            
            // 병사 수가 (-)가 되면
            if(n<0){
                if(k>0){
                    n += q.poll();
                    k--;
                } else {
                    break;
                }
            }
            count++;
        }
        return count;
    }
}