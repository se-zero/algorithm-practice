import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer=0;
        
        for(int i=0; i<=discount.length-10; i++){
            // 초기화
            Map<String, Integer> count = new HashMap<>();
            for(int j=0; j<want.length; j++){
                count.put(want[j], number[j]);
            }
            
            // 시작일로부터 10일 검사
            boolean isMatch = true;
            for(int j=i; j<i+10; j++){
                if(count.containsKey(discount[j]) && count.get(discount[j])>0){
                    count.put(discount[j],count.get(discount[j]) - 1);
                } else {
                    isMatch= false;
                    break;
                }
            }
            if(isMatch){
                answer++;
            }
            
        }
        return answer;
    }
}