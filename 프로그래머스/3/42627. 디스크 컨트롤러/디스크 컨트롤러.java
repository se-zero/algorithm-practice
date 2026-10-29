import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; 
            } else {
                return a[1] - b[1]; 
            }
        });
        
        
        int t = 0; // 현재 시간
        int index = 0; // job 배열 index
        int totalTime = 0; // 모든 작업의 반환 시간 총합
        
        while(index < jobs.length || !queue.isEmpty()){
            
            // 현재 시간(t) 이전에 도착한 모든 작업을 큐에 싹 다 집어넣기
            while(index < jobs.length && jobs[index][0] <= t) {
                queue.offer(jobs[index]);
                index ++;
            }
            
            if (queue.isEmpty()) {
                t = jobs[index][0]; // 다음 작업 도착 시간으로 점프
            } else {
                int[] job = queue.poll();
                totalTime += t + job[1] - job[0]; // 반환시간 누적
                t += job[1]; // 작업 처리시간 후로 점프
            }
        }
        
        return totalTime / jobs.length;
        
        
    }
}