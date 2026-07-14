class Solution {
    public int solution(int[][] signals) {
        int trafficLight = signals.length;
        int[] period = new int[trafficLight];

        for (int i = 0; i < trafficLight; i++) {
            period[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        int total = period[0];
        for (int i = 1; i < period.length; i++) {
            total = lcm(total, period[i]);
        }

        for (int t = 0; t <= total; t++) {
            boolean allYellow = true;

            for (int i = 0; i < trafficLight; i++) {
                int green = signals[i][0];
                int yellow = green + signals[i][1];

                int time = t % period[i];

                if (time <= green || time > yellow) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) {
                return t;
            }
        }
        return -1;
    }

    static int gcd(int a, int b) {
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a / gcd(a,b) * b;
    }
}