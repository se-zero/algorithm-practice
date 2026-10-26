class Solution {
    public long solution(int[] sequence) {
        long[] dp1 = new long[sequence.length]; //[1,-1,1,..]
        long[] dp2 = new long[sequence.length]; //[-1,1,-1,..]
        
        // 초기값 설정
        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];
        
        for(int i = 1; i < sequence.length; i++){
            if(i % 2 == 0){
                dp1[i] = Math.max(dp1[i-1]+sequence[i], sequence[i]);
                dp2[i] = Math.max(dp2[i-1]-sequence[i], -sequence[i]);
            } else {
                dp1[i] = Math.max(dp1[i-1]-sequence[i], -sequence[i]);
                dp2[i] = Math.max(dp2[i-1]+sequence[i], sequence[i]);
            }   
        }
        
        long max = 0;
        for(int i = 0; i < sequence.length; i++) {
            long dpMax = Math.max(dp1[i], dp2[i]);
            max = Math.max(max, dpMax);
        }
        return max;
    }
}