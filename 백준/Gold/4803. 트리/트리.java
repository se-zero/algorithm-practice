import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int caseNumber = 1;
    static boolean hasCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) break;

            List<Integer>[] graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            boolean[] visited = new boolean[n+1];
            int treeCount = 0;

            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    hasCycle =false;
                    dfs(graph, visited, i, 0);

                    if (!hasCycle) {
                        treeCount++;
                    }
                }

            }

            sb.append("Case ").append(caseNumber).append(": ");
            if (treeCount == 0){
                sb.append("No trees.");
            } else if (treeCount == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(treeCount).append(" trees.");
            }

            sb.append("\n");

            caseNumber++;
        }

        System.out.println(sb);
    }

    static void dfs(List<Integer>[] graph, boolean[] visited, int current, int parent){
        visited[current] =true;

        for (int next: graph[current]) {
            if (next == parent) continue;

            if (visited[next]) {
                hasCycle = true;
                continue;
            }

            dfs(graph, visited, next, current);
        }
    }
}
