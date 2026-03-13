import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] prev = new int[10000];
    static char[] command = new char[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A,B);

            int cur = B;
            Stack<Character> stack = new Stack<>();
            while(cur != A){
                stack.push(command[cur]);
                cur = prev[cur];
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb);
        }

    }

    static void bfs(int start, int end){
        Arrays.fill(prev, -1);

        prev[start] = start;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == end) break;

            int d = D(cur);
            if (prev[d] == -1) {
                q.add(d);
                prev[d] = cur;
                command[d] = 'D';

            }

            int s = S(cur);
            if (prev[s] == -1) {
                q.add(s);
                prev[s] = cur;
                command[s] = 'S';

            }


            int l = L(cur);
            if (prev[l] == -1) {
                q.add(l);
                prev[l] = cur;
                command[l] = 'L';

            }


            int r = R(cur);
            if (prev[r] == -1) {
                q.add(r);
                prev[r] = cur;
                command[r] = 'R';

            }
        }

    }

    static int D(int num) {
        return (num * 2) % 10000;
    }

    static int S(int num) {
        if(num==0){
            num = 9999;
        } else {
            num -= 1;
        }
        return num;
    }

    static int L(int num) {
        int a = num / 1000;
        int b = num % 1000;
        num = b*10 + a;
        return num;
    }

    static int R(int num) {
        int a = num % 10;
        int b = num / 10;
        num = a*1000 + b;
        return num;
    }

}
