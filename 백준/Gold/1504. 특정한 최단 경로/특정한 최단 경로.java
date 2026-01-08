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

    static final int INF = Integer.MAX_VALUE;
    static int N, E;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());;

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dijkstra(1);
        int[] dv1 = dijkstra(v1);
        int[] dv2 = dijkstra(v2);

        long path1 = INF;
        long path2 = INF;

        if (d1[v1] != INF && dv1[v2] != INF && dv2[N] != INF) {
            path1 = (long) d1[v1] + dv1[v2] + dv2[N];
        }

        if (d1[v2] != INF && dv2[v1] != INF && dv1[N] != INF) {
            path2 = (long) d1[v2] + dv2[v1] + dv1[N];
        }

        long ans = Math.min(path1, path2);

        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

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
        return dist;
    }
}
