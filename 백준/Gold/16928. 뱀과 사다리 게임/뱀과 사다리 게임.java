import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] board = new int[101];
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=100; i++){
            board[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=0;

        while(!q.isEmpty()){
            int current = q.poll();

            if(current==100){
                System.out.print(visited[current]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if(next>100){
                    continue;
                }

                next = board[next];

                if(visited[next]==0){
                    visited[next] = visited[current]+1;
                    q.add(next);
                }
            }

        }
    }
}
