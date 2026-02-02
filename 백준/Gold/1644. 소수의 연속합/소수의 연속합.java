import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 0; i*i <= n; i++) {
            if(isPrime[i]){
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j]=false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]){
                primes.add(i);
            }
        }

        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < primes.size(); right++) {
            sum += primes.get(right);

            while(sum > n){
                sum -= primes.get(left++);
            }

            if(sum==n){
                count++;
            }
        }
        System.out.println(count);
    }
}
