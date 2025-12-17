import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] visited = new int[100001];
    static int N;
    static int M;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == M){
            System.out.print(0);
        }
        else {
            bfs(N);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            int[] next = {now-1, now+1, now*2};
            for (int move : next) {
                if (move == M) {
                    System.out.print(visited[now]);
                    return;
                }
                if(move >= 0 && move <= 100000 && visited[move] == 0) {
                    q.add(move);
                    visited[move] = visited[now]+1;
                }

            }
        }
    }
}
