import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] details = new String[files.length][3];
        
        for(int i=0; i<files.length;i++){
            String file = files[i];
            int numStart = -1;
            int numEnd = -1;
            
            // NUMBER 시작 위치 찾기
            for (int j = 0; j < file.length(); j++) {
                if (Character.isDigit(file.charAt(j))) {
                    numStart = j;
                    break;
                }
            }
            
            // TAIL 시작 위치 찾기
            for (int j = numStart; j < file.length(); j++) {
                if (!Character.isDigit(file.charAt(j))) {
                    numEnd = j;
                    break;
                }
            }
            
            //파일명이 숫자로 끝나는 경우
            if (numEnd == -1) numEnd = file.length();
            
            // NUMBER이 5글자를 넘어가는 경우
            if (numEnd - numStart > 5) numEnd = numStart + 5;
            
            details[i][0] = files[i].substring(0,numStart);
            details[i][1] = files[i].substring(numStart,numEnd);
            details[i][2] = files[i].substring(numEnd);
        }
        
        // 정렬
        Arrays.sort(details, (a,b) ->{
            String head1 = a[0].toLowerCase();
            String head2 = b[0].toLowerCase();
            
            int headCompare = head1.compareTo(head2);
            if(headCompare != 0){
                return headCompare;
            }
            
            int num1 = Integer.parseInt(a[1]);
            int num2 = Integer.parseInt(b[1]);
            
            return num1 - num2;
        });
        
        String[] answer = new String[files.length];
        for (int i = 0; i < details.length; i++) {
            answer[i] = details[i][0] + details[i][1] + details[i][2];
        }
        
        return answer;
    }
}