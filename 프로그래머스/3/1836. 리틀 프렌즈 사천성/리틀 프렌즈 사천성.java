import java.util.HashMap;
import java.util.Map;

class Solution {
    char[][] realBoard;
    public String solution(int m, int n, String[] board) {
        realBoard = new char[m][n];
        Map<Character, int[]> location = new HashMap<>();

        // 2차원 배열 초기화, 좌표 저장
        for (int i = 0; i < m; i++) {
            String tile = board[i];
            for (int j = 0; j < n; j++) {
                realBoard[i][j] = board[i].charAt(j);
                if(tile.charAt(j) != '*' && tile.charAt(j) != '.'){
                    if(location.containsKey(tile.charAt(j))){
                        int[] tmp = location.get(tile.charAt(j));
                        location.put(tile.charAt(j), new int[]{tmp[0], tmp[1], i,j});
                    } else {
                        location.put(tile.charAt(j), new int[]{i,j});
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        
        // 모든 짝을 맞출 때까지 반복
        while (!location.isEmpty()) {
            boolean removed = false;

            for (char c = 'A'; c <= 'Z'; c++) {
                if(location.containsKey(c)) {
                    int[] positions = location.get(c);
                    int r1 = positions[0];
                    int c1 = positions[1];
                    int r2 = positions[2];
                    int c2 = positions[3];

                    // 경로가 뚫려있는지 확인
                    if(canConnect(r1,c1,r2,c2)) {
                        realBoard[r1][c1] = '.';
                        realBoard[r2][c2] = '.';
                        location.remove(c);
                        answer.append(c);
                        removed = true;

                        // 다시 앞 알파벳부터 시작 하기 위해 break
                        break;
                    }
                }
            }
            if(!removed) {
                return "IMPOSSIBLE";
            }
        }
        return answer.toString();
    }

    // 두 좌표가 연결될 수 있는지 확인
    private boolean canConnect(int r1, int c1, int r2, int c2) {
        // 직선
        if(r1 == r2 || c1 == c2) {
            return canGo(r1, c1, r2, c2);
        }

        // 코너
        if(realBoard[r1][c2] == '.' && canGo(r1, c1, r1, c2) && canGo(r1, c2, r2, c2)) {
            return true;
        }

        // 코너
        if (realBoard[r2][c1] == '.' && canGo(r1, c1, r2, c1) && canGo(r2, c1, r2, c2)) {
            return true;
        }

        return false;
    }

    // 두 좌표 사이가 일직선으로 뚫려있는지 확인
    private boolean canGo(int r1, int c1, int r2, int c2){
        if (r1 == r2) {
            int min = Math.min(c1, c2);
            int max = Math.max(c1, c2);

            for (int i = min + 1; i < max; i++) {
                if (realBoard[r1][i] != '.') return false;
            }
            return true;
        } else if (c1 == c2) {
            int min = Math.min(r1, r2);
            int max = Math.max(r1, r2);
            for (int i = min + 1; i < max; i++) {
                if (realBoard[i][c1] != '.') return false;
            }
            return true;
        }
        return false;
    }
}
