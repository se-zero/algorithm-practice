import java.util.*;

class Solution {
    public int solution(String word) {
        
        List<String> dict = new ArrayList<>();
        makeTree(dict, "");
        
        return dict.indexOf(word)+1;
    }
    
    private void makeTree(List<String> dict, String currentStr) {
        if(currentStr.length() > 5){
            return;
        }
        if(!currentStr.equals("")) {
            dict.add(currentStr);
        }
        
        makeTree(dict, currentStr + "A");
        makeTree(dict, currentStr + "E");
        makeTree(dict, currentStr + "I");
        makeTree(dict, currentStr + "O");
        makeTree(dict, currentStr + "U");
    }
}

