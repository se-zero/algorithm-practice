import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] dist = new int[100001];
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);

        int result = bfs(N);
        System.out.print(result);
    }

    static int bfs(int start){
        Deque<Integer> dq = new LinkedList<>();
        dq.add(start);
        dist[start]=0;

        while(!dq.isEmpty()){
            int now = dq.pollFirst();

            if(now == K){
                return dist[now];
            }

            int teleport = now * 2;
            if(teleport <= 100000 && dist[teleport] > dist[now]){
                dq.addFirst(teleport);
                dist[teleport] = dist[now];
            }

            int back = now - 1;
            if(back >= 0 && dist[back] > dist[now]+1){
                dq.addLast(back);
                dist[now-1] = dist[now] + 1;
            }

            int forward = now + 1;
            if(forward <= 100000 && dist[forward] > dist[now] + 1){
                dq.addLast(forward);
                dist[forward] = dist[now] + 1;
            }
        }
        return -1;
    }
}
