class Solution {
    int[][] damage = {{1,1,1}, {5,1,1}, {25,5,1}};
    int minDamage = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        // 첫 곡갱이 선택
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                dfs(picks, minerals, i, 0, 0);
                picks[i]++;
            }
        }

        return minDamage == Integer.MAX_VALUE ? 0 : minDamage;
    }

    public void dfs(int[] picks, String[] minerals, int type, int index, int currentDamage) {
        // 5개 광물 캐기
        for (int i = 0; i < 5; i++) {
            if(index >= minerals.length) {
                minDamage = Math.min(minDamage, currentDamage);
                return;
            }

            if(minerals[index].equals("diamond")) currentDamage += damage[type][0];
            if(minerals[index].equals("iron")) currentDamage += damage[type][1];
            if(minerals[index].equals("stone")) currentDamage += damage[type][2];

            index++;
        }
        
        // 곡갱이가 모두 소진된 경우
        if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            minDamage = Math.min(minDamage, currentDamage);
            return;
        }

        // 다음 곡갱이 선택
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                dfs(picks, minerals, i, index, currentDamage);
                picks[i]++;
            }
        }
    }
}