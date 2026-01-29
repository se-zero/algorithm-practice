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

        int sum = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        int count=0;

        while(left<right){
            if(arr[left] + arr[right] == sum){
                count++;
                left++;
                right--;
            } else if(arr[left] + arr[right] > sum){
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}
