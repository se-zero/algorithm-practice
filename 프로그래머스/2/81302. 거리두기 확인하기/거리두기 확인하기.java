import java.util.ArrayList;
import java.util.List;

class Solution {

    private static class Point {
        int r, c;
        Point(int r, int c) { this.r = r; this.c = c; }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 대기실 전체 순회
        for (int i = 0; i < 5; i++) {
            char[][] room = new char[5][5];
            List<Point> plist = new ArrayList<>();
            boolean isSafe = true;

            // 대기실 별로 배열로 표현
            for (int j = 0; j < 5; j++) {
                room[j] = places[i][j].toCharArray();
            }

            // 응시자 위치 수집
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if(room[r][c] == 'P') {
                        plist.add(new Point(r,c));
                    }
                }
            }

            // 응시자 간 거리두기 계산
            for (int j = 0; j < plist.size(); j++) {
                for (int k = j+1; k < plist.size(); k++) {
                    Point p1 = plist.get(j);
                    Point p2 = plist.get(k);

                    int dist = Math.abs(p1.r-p2.r) + Math.abs(p1.c-p2.c);

                    if(dist > 2){
                        continue;
                    } else if (dist == 1) {
                        isSafe = false;
                        break;
                    } else if (dist == 2) {
                        if(p1.r == p2.r) {
                            if(room[p1.r][p1.c+1] != 'X') isSafe = false;
                        } else if (p1.c == p2.c) {
                            if(room[p1.r+1][p1.c] != 'X') isSafe = false;
                        } else {
                            if (room[p1.r][p2.c] != 'X' || room[p2.r][p1.c] != 'X') isSafe = false;
                        }
                    }

                    if (!isSafe) break;
                }
                if (!isSafe) break;
            }
            answer[i] = isSafe ? 1 : 0;
        }
        return answer;
    }
}