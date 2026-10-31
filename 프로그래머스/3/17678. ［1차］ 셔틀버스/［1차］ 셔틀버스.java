import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        // 모든 크루 시간 큐에 삽입
        for(String timeStr : timetable){
            q.offer(timeToMin(timeStr));
        }
        
        int busTime = timeToMin("09:00"); // 첫 버스 도착 시간
        int cornTime = 0; // 콘이 도착해야할 시간
        
        for(int i = 0; i<n; i++){
            int person = 0;
            int lastPersonTime = 0;
            
            while(!q.isEmpty() && person < m){
                if(q.peek() <= busTime){
                    lastPersonTime = q.poll();
                    person++;
                } else {
                    break;
                }
            }
            
            // 콘 시간 결정
            if(i == n-1){
                if(person == m){
                    cornTime = lastPersonTime-1;
                } else {
                    cornTime = busTime;
                }
            } 
            
            // 다음 버스 시간
            busTime += t;
        }
        
        StringBuilder sb = new StringBuilder();
        int h = cornTime/60;
        if(h<10) sb.append(0);
        sb.append(h).append(":");

        cornTime %= 60;
        if (cornTime < 10) sb.append("0");
        sb.append(cornTime);
        
        return sb.toString();
    }
    
    // 문자열을 분 단위 int로 변환
    private int timeToMin(String str){
        String[] parts = str.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}