import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v;
        int w;

        Node(int v, int w){
            this.v=v;
            this.w=w;
        }

        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        dist[start]=0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        dijkstra(start);

        for(int i=1; i< V+1; i++){
            if(dist[i]!=Integer.MAX_VALUE){
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.v;
            int curDist = cur.w;

            if(dist[now]<curDist){
                continue;
            }

            for(Node n : graph[now]){
                int next = n.v;
                int cost = curDist + n.w;

                if(dist[next]>cost){
                    dist[next] = cost;
                    pq.add(new Node(next,cost));
                }
            }
        }
    }
}
