import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static long[] D;
    static List<Edge> edges;
    static final long INF = Long.MAX_VALUE / 4;

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        D = new long[n+1];
        Arrays.fill(D, INF);
        D[1]=0;

        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, cost));
        }

        boolean hasNegativeCycle = bellmanFord();

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (D[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(D[i]);
                }
            }
        }
    }
    static boolean bellmanFord() {
        for (int i = 1; i <= n - 1; i++) {
            for (Edge e : edges) {
                if (D[e.from] != INF &&
                        D[e.to] > D[e.from] + e.cost) {
                    D[e.to] = D[e.from] + e.cost;
                }
            }
        }

        for (Edge e : edges) {
            if (D[e.from] != INF &&
                    D[e.to] > D[e.from] + e.cost) {
                return true;
            }
        }
        return false;
    }
}
