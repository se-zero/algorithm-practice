class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max_health = health;
        int health_time = 0;
        int index = 0;

        int time = attacks[attacks.length-1][0];
        for (int i = 1; i <= time; i++) {

            if(attacks[index][0]==i) {
                health -= attacks[index][1];

                if(health <= 0) return -1;

                index++;
                health_time = 0;
            } else {
                health_time++;

                int next_health = health + bandage[1];
                
                if (health_time == bandage[0]) {
                    next_health += bandage[2];
                    health_time = 0;
                }

                health = Math.min(next_health, max_health);
            }
        }

        return health == 0 ? -1 : health;
    }
}