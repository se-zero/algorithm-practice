class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // 주고 받은 선물
        int[][] giftHistory = new int[friends.length][friends.length];
        for (String names : gifts) {
            String[] name = names.split(" ");

            int indexA = -1;
            int indexB = -1;
            for (int i = 0; i < friends.length; i++) {
                if(friends[i].equals(name[0]) ){
                    indexA = i;
                } else if (friends[i].equals(name[1])) {
                    indexB = i;
                }
            }
            giftHistory[indexA][indexB]++;
        }

        // 선물 지수 계산
        int[] giftIndex = new int[friends.length];
        for (int i = 0; i < giftIndex.length; i++) {
            int give = 0;
            int receive = 0;

            for (int j = 0; j < giftIndex.length; j++) {
                if(j == i) continue;
                give += giftHistory[i][j];
            }

            for (int j = 0; j < giftIndex.length; j++) {
                if(j == i) continue;
                receive += giftHistory[j][i];
            }

            giftIndex[i] = give - receive;
        }

        // 다음달 선물 받을 개수
        int[] nextMonth = new int[friends.length];
        for (int i = 0; i < giftHistory.length; i++) {
            for (int j = 0; j < giftHistory.length; j++) {
                if(i == j) continue;;

                if(giftHistory[i][j] > giftHistory[j][i]) nextMonth[i]++;

                if(giftHistory[i][j] == giftHistory[j][i] && giftIndex[i] > giftIndex[j]) nextMonth[i]++;
            }
        }

        int answer = 0;
        for(int num : nextMonth){
            answer = Math.max(answer, num);
        }
        return answer;
    }
}