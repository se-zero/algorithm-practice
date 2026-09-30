import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 총 보석 개수
        Set<String> gemType = new HashSet<>(Arrays.asList(gems));
        int totalType = gemType.size();

        Map<String, Integer> gemCount = new HashMap<>();
        Queue<String> buy = new LinkedList<>();

        int start = 0;
        int answerStart = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < gems.length; i++) {
            String gem = gems[i];

            // 보석 큐에 추가
            gemCount.put(gem, gemCount.getOrDefault(gem,0)+1);
            buy.offer(gem);
            
            // 큐 앞에 중복 보석 제거
            while (gemCount.get(buy.peek()) > 1) {
                String poll = buy.poll();
                gemCount.put(poll, gemCount.get(poll) - 1);
                start++;
            }
            
            // 모든 보석 종류가 모였다면, 최소구간 비교
            if(gemCount.size() == totalType){
                if(buy.size() < minLength) {
                    minLength = buy.size();;
                    answerStart = start;
                }
            }
        }
        
        return new int[]{answerStart+1, answerStart+minLength};
    }
}