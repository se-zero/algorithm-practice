class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            // 이진수 문자열로 변환
            String bi = Long.toBinaryString(numbers[i]);
            int len = bi.length();
            
            int h = 1;
            int treeLen = 1;
            
            // 포화트리 길이 찾기
            while(treeLen < len){
                h++;
                treeLen = (int) Math.pow(2, h) - 1;
            }
            
            // 부족한 만큼 0 채우기
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < treeLen - len; j++){
                sb.append(0);
            }
            sb.append(bi);
            
            String fullTree = sb.toString();
            
            if (checkTree(fullTree)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }

    private boolean checkTree(String tree){
        if(tree.length() == 1) {
            return true;
        }
        
        int mid = tree.length() / 2;
        char root = tree.charAt(mid);
        
        String left = tree.substring(0,mid);
        String right = tree.substring(mid+1);
        
        if(root == '0' && (left.contains("1") || right.contains("1"))) {
            return false;
        }
        
        return checkTree(left) && checkTree(right);
    }
    
    
    
}