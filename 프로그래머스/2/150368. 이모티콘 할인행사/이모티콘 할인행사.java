class Solution {
    int maxCount; // 최대 가입자 수
    int maxTotalPrice; // 최대 판매액
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] discounts = new int[emoticons.length];
        
        dfs(0, discounts, emoticons, users);

        answer[0] = maxCount;
        answer[1] = maxTotalPrice;
        return answer;
    }


    public void dfs(int depth, int[] discounts, int[] emoticons, int[][] users) {
        // 모든 이모티콘의 할인율 결정 완료
        if (depth == emoticons.length) {
            int count = 0;
            int totalPrice = 0;
            
            // 각 유저별 시뮬레이션
            for (int i = 0; i < users.length ; i++) {
                int price = 0;
                
                for (int j = 0; j < discounts.length; j++) {
                    if(discounts[j] >= users[i][0]) {
                        price += emoticons[j] * (100 - discounts[j]) / 100;
                    }
                }
                
                if(price >= users[i][1]) {
                    count++;
                } else {
                    totalPrice += price;
                }
            }
            
            // 최고 기록 갱신
            if(maxCount < count) {
                maxCount = count;
                maxTotalPrice = totalPrice;
            } else if (maxCount == count) {
                maxTotalPrice = Math.max(maxTotalPrice, totalPrice);
            }
            return;
        }

        int[] rates = {10, 20, 30, 40};
        for (int rate : rates) {
            discounts[depth] = rate;
            dfs(depth + 1, discounts, emoticons, users);
        }
    }

}