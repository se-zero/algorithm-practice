import java.util.Arrays;

class Solution {
    public int solution(int[] a) {
        // 각 인덱스 기준 왼쪽과 오른쪽의 최솟값을 저장하는 배열
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        // 초기화
        Arrays.fill(leftMin, Integer.MAX_VALUE);
        Arrays.fill(rightMin, Integer.MAX_VALUE);
        
        // 최솟값 갱신
        for(int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i-1], leftMin[i-1]);
        }
        for(int i = a.length-2; i >= 0; i--) {
            rightMin[i] = Math.min(a[i+1], rightMin[i+1]);
        }
        
        // 생존 가능 여부 판단
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if(i == 0 || i == a.length-1) {
                count++;
            } else {
                if(a[i] > leftMin[i] && a[i] > rightMin[i]){
                    continue;
                } else {
                    count++;
                }
                
            }
        }
        return count;
        
    }
}