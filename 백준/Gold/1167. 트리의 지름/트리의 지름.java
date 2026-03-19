import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] graph;
    static boolean[] visited;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());

            while(true) {

                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                graph[node].add(new int[]{next,weight});
            }
        }

        visited = new boolean[V+1];
        dist = new int[V+1];

        int far = bfs(1);

        Arrays.fill(visited,false);
        Arrays.fill(dist, 0);
        int realFar = bfs(far);

        System.out.println(dist[realFar]);

    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int far = 0;
        int farNode = 0;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int[] next : graph[current]){
                if(!visited[next[0]]){
                    visited[next[0]] =true;
                    q.offer(next[0]);
                    dist[next[0]] = dist[current] + next[1];
                    if(dist[next[0]]>far){
                        far = dist[next[0]];
                        farNode = next[0];
                    }
                }
            }
        }
        return farNode;
    }

}
