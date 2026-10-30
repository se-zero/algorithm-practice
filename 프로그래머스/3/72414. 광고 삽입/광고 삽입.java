class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        // 영상 전체 시간을 초로 변환
        int playSec = timeToSec(play_time);
        
        // 시간 배열
        int[] time = new int[360000];
        
        // 시청자 시작/종료 시점 마킹
        for (String log : logs) {
            String[] times = log.split("-");
            int startSec = timeToSec(times[0]);
            int endSec = timeToSec(times[1]);
            
            time[startSec]++;
            time[endSec]--;
        }
        
        // 누적합으로 초당 시청자 수 계산
        for(int i = 1; i <= playSec; i++){
            time[i] += time[i-1];
        }
        
        // 광고 시간을 초로 변환
        int advSec = timeToSec(adv_time);
        
        // 0초부터 advSec까지의 초기 누적 시청 시간
        long currentSum = 0;
        for(int i = 0; i < advSec; i++) {
            currentSum += time[i];
        }
        
        long maxSum = currentSum;
        int maxStartTime = 0;
        
        // 최대 시청 시간 갱신
        for(int i=advSec; i<playSec; i++){
            currentSum = currentSum + time[i] - time[i - advSec];
            
            if(currentSum > maxSum){
                maxSum = currentSum;
                maxStartTime = i - advSec + 1;
            }
        }
        
        return secToTime(maxStartTime);
        
    }
    
    private int timeToSec(String str) {
        String[] parts = str.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }
    
    private String secToTime(int time) {
        StringBuilder sb = new StringBuilder();
        
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = time % 60;
        
        if (h < 10) sb.append("0");
        sb.append(h).append(":");
    
        if (m < 10) sb.append("0");
        sb.append(m).append(":");
    
        if (s < 10) sb.append("0");
        sb.append(s);
        
        return sb.toString();
    }
}