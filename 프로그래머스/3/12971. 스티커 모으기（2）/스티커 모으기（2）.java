class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];

        // dp1: 0번 인덱스 선택, dp2: 인덱스 0번 포기
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        // 초기값 설정
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        
        dp2[0] = 0;
        dp2[1] = sticker[1];


        for (int i = 2; i < sticker.length; i++) {
            // 0번을 뜯었으므로 마지막 인덱스 포기
            if(i == sticker.length-1) {
                dp1[i] = dp1[i-1];
            } else {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
            }
            
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        return Math.max(dp1[sticker.length-1], dp2[sticker.length-1]);
    }
}