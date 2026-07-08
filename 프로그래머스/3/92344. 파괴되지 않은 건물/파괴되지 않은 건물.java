class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] tmp = new int[board.length+1][board[0].length+1];
        for (int[] skills : skill) {
            int r1 = skills[1];
            int c1 = skills[2];
            int r2 = skills[3];
            int c2 = skills[4];

            if (skills[0] == 1) {
                tmp[r1][c1] -= skills[5];
                tmp[r1][c2 + 1] += skills[5];
                tmp[r2 + 1][c1] += skills[5];
                tmp[r2 + 1][c2 + 1] -= skills[5];
            } else if (skills[0] == 2) {
                tmp[r1][c1] += skills[5];
                tmp[r1][c2 + 1] -= skills[5];
                tmp[r2 + 1][c1] -= skills[5];
                tmp[r2 + 1][c2 + 1] += skills[5];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                tmp[i][j] += tmp[i][j-1];
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 1; j <= board.length; j++) {
                tmp[j][i] += tmp[j-1][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += tmp[i][j];
            }
        }

        int answer = 0;
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]>0){
                    answer++;
                }
            }
        }
        return answer;
    }
}