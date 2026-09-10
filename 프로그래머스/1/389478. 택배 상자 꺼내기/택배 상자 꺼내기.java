import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int w, int num) {
        // num의 위치 구하기
        int numRow = (num - 1) / w;
        int numCol = (numRow % 2 == 0) ? (num - 1) % w : (w - 1 - ((num - 1) % w));

        // 마지막 상자 층수 구하기
        int nRow = (n-1) / w;
        
        // 마지막 상자 층수에서 num 열의 번호 구하기
        int boxAtLastRow;
        if(nRow % 2 ==0){
            boxAtLastRow = nRow * w + numCol + 1;
        } else {
            boxAtLastRow = nRow * w + (w - 1 - numCol) + 1;
        }
        
        // num 열의 꼭대기 행 구하기
        int maxRowInCol = (boxAtLastRow <= n) ? nRow : nRow-1;
        
        return maxRowInCol - numRow + 1;
    }
}