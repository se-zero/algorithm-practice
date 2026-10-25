import java.util.*;

class Solution {
    class Word{
        String word;
        int count;
        
        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] isvisited = new boolean[words.length];
        
        // 최단 경로 탐색을 위한 bfs 큐 생성 및 초기화
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        
        while(!queue.isEmpty()){
            Word w = queue.poll();
            
            if(w.word.equals(target)){
                return w.count;
            }
            
            // words 배열 안의 모든 단어와 비교
            for(int i=0; i< words.length; i++){
                if(canConvert(w.word, words[i]) && !isvisited[i]){
                    queue.offer(new Word(words[i],w.count+1));
                    isvisited[i] = true;
                }
            }
        }
        return 0;
    }
    
    // 한글자만 다른지 확인
    private boolean canConvert(String word1, String word2){
        int diff = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diff++;
            }
        }
        return diff==1;
    }
}