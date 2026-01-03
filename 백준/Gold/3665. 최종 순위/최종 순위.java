import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());

            int[] lastYear = new int[N + 1];

            int[] indegree = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i < N; i++) {
                for (int j = i+1; j <= N; j++) {
                    graph[lastYear[i]].add(lastYear[j]);
                    indegree[lastYear[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(graph[a].contains(b)){
                    graph[a].remove(Integer.valueOf(b));
                    graph[b].add(a);

                    indegree[b]--;
                    indegree[a]++;
                } else{
                    graph[b].remove(Integer.valueOf(a));
                    graph[a].add(b);

                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < N+1; i++) {
                if(indegree[i]==0){
                    q.add(i);
                }
            }

            List<Integer> result = new LinkedList<>();
            boolean ambiguous = false;
            while(!q.isEmpty()){
                if(q.size()>=2){
                    ambiguous = true;
                }
                int now = q. poll();
                result.add(now);
                for(int next : graph[now]){
                    indegree[next]--;
                    if(indegree[next]==0){
                        q.add(next);
                    }
                }
            }

            if(result.size()<N){
                System.out.println("IMPOSSIBLE");
            } else if(result.size() == N && ambiguous){
                System.out.println("?");
            } else {
                StringBuilder sb = new StringBuilder();
                for(int x : result){
                    sb.append(x).append(" ");
                }
                System.out.println(sb);
            }


        }
    }
}
