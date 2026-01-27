import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge{
        int to;
        int cost;

        Edge(int to, int cost){
            this.to=to;
            this.cost=cost;
        }

    }

    static class Node implements Comparable<Node>{
        int v;
        int dist;

        Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist-o.dist;
        }
    }
    static List<Edge>[] graph;

    static int[] distS;
    static int[] distG;
    static int[] distH;

    static final int INF = 1_000_000_000;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st= new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int ghCost = 0;
            for (int i = 0; i < m; i++) {
                st= new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new Edge(b,d));
                graph[b].add(new Edge(a,d));

                if ((a == g && b == h) || (a == h && b == g)) {
                    ghCost = d;
                }
            }

            List<Integer> targets = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                targets.add(Integer.parseInt(br.readLine()));
            }

            distS = dijkstra(s,n);
            distG = dijkstra(g,n);
            distH = dijkstra(h,n);

            Collections.sort(targets);

            for(int x : targets) {
                int path1 = distS[g] + ghCost + distH[x];
                int path2 = distS[h] + ghCost + distG[x];

                if(path1 == distS[x] || path2 == distS[x]){
                    sb.append(x).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    static int[] dijkstra(int start,int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.dist>dist[cur.v]) continue;

            for(Edge e : graph[cur.v]){
                if (dist[e.to] > cur.dist + e.cost) {
                    dist[e.to] = cur.dist + e.cost;
                    pq.add(new Node(e.to, dist[e.to]));
                }
            }
        }
        return dist;
    }

}
