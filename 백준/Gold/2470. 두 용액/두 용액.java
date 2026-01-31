import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int best_letf = 0;
        int best_right = n-1;
        long best = (long)arr[left] + arr[right];

        while(left<right){
            long sum = (long)arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(best)) {
                best = sum;
                best_letf = left;
                best_right = right;
            }

            if (sum < 0) left++;
            else if (sum > 0) right--;
            else break;
        }

        System.out.println(arr[best_letf] + " " + arr[best_right]);
    }
}
