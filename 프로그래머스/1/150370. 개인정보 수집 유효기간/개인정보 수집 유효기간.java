import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 파싱
        String[] todayParts = today.split("\\.");
        int[] date = new int[todayParts.length];
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);

        // 약관 정보 매핑
        Map<Character,Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] termParts = term.split(" ");
            char type = termParts[0].charAt(0);
            int duration = Integer.parseInt(termParts[1]);
            termMap.put(type, duration);
        }

        // privacies 수집
        List<Integer> expiredList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            // 수집 일자 파싱
            String[] privacyParts = privacies[i].split(" ");
            String[] expireDateParts = privacyParts[0].split("\\.");
            int expireYear = Integer.parseInt(expireDateParts[0]);
            int expireMonth = Integer.parseInt(expireDateParts[1]);
            int expireDay = Integer.parseInt(expireDateParts[2]);

            int duraion = termMap.get(privacyParts[1].charAt(0));

            // 만료 일 계산
            expireDay--;
            if(expireDay==0){
                expireDay = 28;
                expireMonth--;
            }

            // 만료 연/월 계산
            expireMonth += duraion;
            while(expireMonth>12){
                expireYear++;
                expireMonth-=12;
            }

            // 만료 여부
            boolean isExpired = false;
            if (todayYear > expireYear) {
                isExpired = true;
            } else if (todayYear == expireYear && todayMonth > expireMonth) {
                isExpired = true;
            } else if (todayYear == expireYear && todayMonth == expireMonth && todayDay > expireDay) {
                isExpired = true;
            }

            if(isExpired) expiredList.add(i+1);

        }

        int[] answer = new int[expiredList.size()];
        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i);
        }
        return answer;
    }
}