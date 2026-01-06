import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indgree = new int[N+1];
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i = 0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int later = Integer.parseInt(st.nextToken());

            graph[first].add(later);
            indgree[later]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N ; i++) {
            if(indgree[i]==0){
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");

            for (int next: graph[now]) {
                indgree[next]--;
                if(indgree[next]==0){
                    pq.add(next);
                }
            }

        }
        System.out.print(sb);

    }
}
