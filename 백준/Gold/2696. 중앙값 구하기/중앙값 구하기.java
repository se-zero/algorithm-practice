import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int M = Integer.parseInt(br.readLine());
            out.append((M+1)/2).append('\n');

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();

            int taken =0;
            int printed =0;

            while(taken<M){
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens() && taken < M) {
                    int x = Integer.parseInt(st.nextToken());
                    taken++;

                    if (left.isEmpty() || x <= left.peek()) left.offer(x);
                    else right.offer(x);

                    if (left.size() < right.size()) left.offer(right.poll());
                    if (left.size() > right.size() + 1) right.offer(left.poll());

                    if ((taken & 1) == 1) {
                        out.append(left.peek()).append(' ');
                        printed++;
                        if (printed % 10 == 0) out.append('\n');
                    }
                }
            }
            if (printed % 10 != 0) out.append('\n');
        }
        System.out.print(out);


    }
}