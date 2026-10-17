import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        // 완호 점수 저장
        int[] wanho = scores[0];
        
        Arrays.sort(scores, (a,b) -> {
            // 근무 태도 점수가 같으면, 동료 평가 오름차순
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            // 근무 태도 내림차순
            return b[0] - a[0];
        });

        int maxScore = 0; // 동료평가 최고점
        int wanhoSUm = wanho[0] + wanho[1];
        int rank = 1; // 완호 시작 등수
        
        for (int[] score : scores) {
            // 동료평가가 최고점보다 낮다면 탈락
            if(score[1] < maxScore) {
                
                // 완호면 -1 반환
                if(score[0] == wanho[0] && score[1] == wanho[1]) {
                    return -1;
                }
            } else {
                maxScore = Math.max(maxScore, score[1]);
                
                // 완호 등수 밀어내기
                if(score[0] + score[1] > wanhoSUm) {
                    rank++;
                }
            }
        }

        return rank;
    }
}
