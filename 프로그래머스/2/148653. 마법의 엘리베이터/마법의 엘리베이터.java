class Solution {
    public int solution(int storey) {
        int count = 0;
        
        while (storey > 0) {
            if (storey % 10 > 5){
                count += 10 - (storey % 10);
                storey += 10;
            } else if (storey % 10 < 5) {
                count += storey % 10;
            } else {
                count += 5;
                if((storey / 10) % 10 >= 5){
                    storey += 10;
                }
            }
            
            storey /= 10;
        }
        
        return count;
    }
}