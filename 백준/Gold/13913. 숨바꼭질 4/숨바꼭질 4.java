import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] position = new int[100001];
    static int[] prev = new int[100001];
    static int N;
    static int K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(position,-1);
        position[N] = 0;

        bfs(N);

        sb.append(position[K]).append("\n");

        int cur = K;
        Stack<Integer> stack = new Stack<>();
        while(cur != N){
            stack.push(cur);
            cur = prev[cur];
        }
        stack.push(N);

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(cur == K) break;

            int next1 = cur - 1;
            if (next1 >= 0 && next1 <= 100000 && position[next1] == -1) {
                q.add(next1);
                position[next1] = position[cur] +1;
                prev[next1] = cur;
            }

            int next2 = cur + 1;
            if (next2 >= 0 && next2 <= 100000 && position[next2] == -1) {
                q.add(next2);
                position[next2] = position[cur] +1;
                prev[next2] = cur;
            }

            int next3 = cur * 2;
            if (next3 >= 0 && next3 <= 100000 && position[next3] == -1) {
                q.add(next3);
                position[next3] = position[cur] +1;
                prev[next3] = cur;
            }


        }
    }

}
