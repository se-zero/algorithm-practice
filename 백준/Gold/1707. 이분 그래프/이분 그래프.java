import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int V, E;
    static List<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        while(K-->0){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            initGraph();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                addEdge(u,v);
            }

            boolean result = isBipartiteGraph();
            System.out.println(result ? "YES":"NO");
        }
    }

    static void initGraph() {
        graph = new ArrayList[V+1];
        color = new int[V+1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    static void addEdge(int u, int v){
        graph[u].add(v);
        graph[v].add(u);
    }

    static boolean isBipartiteGraph(){
        for (int i = 1; i < V + 1; i++) {
            if(color[i]==0){
                if(!bfs(i)){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start]=1;

        while(!q.isEmpty()){
            int now = q.poll();

            for (int next: graph[now]){
                if(color[next]==0){
                    color[next]=-color[now];
                    q.add(next);
                } else if(color[next] == color[now]){
                    return false;
                }


            }
        }

        return true;
    }

}
