import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();

        // 기본 사전 등록
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.add(String.valueOf(c));
        }

        int i = 0;
        while (i < msg.length()) {
            String w ="";
            while(i < msg.length() && dict.contains(w + msg.charAt(i))){
                w += msg.charAt(i);
                i++;
            }

            answer.add(dict.indexOf(w)+1);

            // 새로운 단어 사전에 추가
            if(i < msg.length()){
                dict.add(w + msg.charAt(i));
            }
        }

        int[] result = new int[answer.size()];
        for (int j = 0; j < answer.size(); j++) {
            result[j] = answer.get(j);
        }
        return result;
    }
}