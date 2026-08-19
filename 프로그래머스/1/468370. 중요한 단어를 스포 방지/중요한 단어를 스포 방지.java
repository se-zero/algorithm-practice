import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> safeWords = new HashSet<>();
        Set<String> spoiledWords = new HashSet<>();
        String[] words = message.split(" ");

        int start =0;
        for(String str : words){
            int end = start + str.length() - 1;
            boolean isSpoiled = false;

            for (int[] range : spoiler_ranges) {
                int sStart = range[0];
                int sEnd = range[1];

                if (Math.max(start, sStart) <= Math.min(end, sEnd)){
                    isSpoiled =true;
                    break;
                }
            }

            if (isSpoiled) {
                spoiledWords.add(str);
            } else {
                safeWords.add(str);  
            }

            start = end + 2;
        }
        
        spoiledWords.removeAll(safeWords);
        
        return spoiledWords.size();
    }
}