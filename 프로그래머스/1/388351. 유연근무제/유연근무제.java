class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int shift = startday - 1;
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            int limit = schedules[i] + 10;
            if (limit % 100 >= 60) limit += 40;

            boolean ok = true;
            
            for (int j = 0; j < 7; j++) {
                // j번째 날의 요일
                int day = (shift + j) % 7;
                
                //토,일 계산 X
                if(day >= 5) continue;
                
                if(timelogs[i][j] > limit){
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }
        return answer;
    }

}