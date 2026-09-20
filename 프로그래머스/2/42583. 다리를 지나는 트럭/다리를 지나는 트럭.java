import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 큐 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        // 대기 큐 초기화
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            truck.add(truck_weights[i]);
        }

        int time = 0;
        int sum = 0;
        
        while (!bridge.isEmpty()) {
            // 맨 앞 트럭(공간) 지나감
            int pass = bridge.poll();
            sum -= pass;
            
            if(!truck.isEmpty()){
                // 다음 트럭 진입 가능 여부 확인
                if (sum + truck.peek() <= weight) {
                    int go = truck.poll();
                    sum += go;
                    bridge.add(go);
                } else {
                    bridge.add(0);
                }
            }
            time ++;
        }
        return time;
    }
}