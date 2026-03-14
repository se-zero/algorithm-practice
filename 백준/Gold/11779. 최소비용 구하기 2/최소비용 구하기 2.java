import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int to;
        int cost;

        Node(int to, int cost){
            this.to=to;
            this.cost=cost;
        }
    }

    static List<Node>[] graph;
    static int[] dist;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        prev = new int[n+1];

        Dijkstra(start);

        List<Integer> path = new ArrayList<>();
        int cur = end;

        while(cur != 0){
            path.add(cur);
            if(cur==start) break;
            cur = prev[cur];
        }
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(path.size()).append("\n");

        for (int city : path) {
            sb.append(city).append(" ");
        }

        System.out.println(sb);

    }

    static public void Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.cost > dist[cur.to]) continue;

            for(Node next : graph[cur.to]) {
                if(dist[next.to] > dist[cur.to] + next.cost){
                    dist[next.to] = dist[cur.to] + next.cost;
                    prev[next.to] = cur.to;

                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

}
