import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] indexRecord = new int[N];
        List<Integer> lis = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if(lis.isEmpty() || lis.get(lis.size()-1) < arr[i]) {
                lis.add(arr[i]);
                indexRecord[i] = lis.size()-1;
            } else {
                int left = 0;
                int right = lis.size()-1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if(lis.get(mid) < arr[i]) {
                        left = mid +1;
                    } else {
                        right = mid;
                    }
                }
                lis.set(left, arr[i]);
                indexRecord[i] = left;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis.size()).append("\n");

        Stack<Integer> stack = new Stack<>();
        int targetIdx = lis.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (indexRecord[i] == targetIdx) {
                stack.push(arr[i]);
                targetIdx--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
