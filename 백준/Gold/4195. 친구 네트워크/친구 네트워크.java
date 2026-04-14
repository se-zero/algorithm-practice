import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String, Integer> map;
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            parent = new int[F*2];
            size = new int[F*2];

            int index = 0;
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if(!map.containsKey(name1)){
                    map.put(name1,index);
                    parent[index]=index;
                    size[index] = 1;
                    index++;
                }
                if(!map.containsKey(name2)){
                    map.put(name2,index);
                    parent[index]=index;
                    size[index] = 1;
                    index++;
                }

                sb.append(union(map.get(name1), map.get(name2))).append('\n');
            }
        }
        System.out.print(sb);
    }

    static int find(int x){
        if(parent[x] == x)   return x;
        return parent[x] = find(parent[x]);
    }

    static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB){
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return size[find(a)];
    }
}
