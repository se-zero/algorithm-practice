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

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[node1].add(new int[]{node2,weight});
            graph[node2].add(new int[]{node1,weight});
        }

        visited = new boolean[n+1];
        dist = new int[n+1];

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
        int farNode = start;

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
