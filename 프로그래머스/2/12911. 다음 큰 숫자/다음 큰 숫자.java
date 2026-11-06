class Solution {
    public int solution(int n) {
        // 이진수 변환
        String binary = Integer.toBinaryString(n);
        
        // 1개수
        int first = 0;
        for(int i=0; i<binary.length(); i++){
                if(binary.charAt(i) == '1'){
                    first++;
                }
        }
        
        // 비교 숫자
        int next = n+1;
        while(true){
            String nextBinary = Integer.toBinaryString(next);
            
            // 1개수
            int second = 0;
            for(int i=0; i<nextBinary.length(); i++){
                if(nextBinary.charAt(i) == '1'){
                    second++;
                }
            }
            
            if(first == second){
                return next;
            } 
        
            next++;
        }
    }
}