import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if(i < n / 2)
                weight1.add(Integer.parseInt(st.nextToken()));
            else
                weight2.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        dfs(0,0,weight1,sum1);
        dfs(0,0,weight2,sum2);

        Collections.sort(sum2);

        long answer= 0;
        for (int i = 0; i < sum1.size(); i++) {
            int searchValue = c - sum1.get(i);
            answer += binarySearch(sum2, searchValue) + 1;
        }

        System.out.print(answer);
    }

    public static void dfs(int index, int sum, ArrayList<Integer> weight, ArrayList<Integer> answer){
        if(sum>c)
            return;
        if(index == weight.size()){
            answer.add(sum);
            return;
        }

        dfs(index + 1, sum + weight.get(index), weight, answer);
        dfs(index + 1, sum, weight, answer);
    }

    public static int binarySearch(ArrayList<Integer> sum, int target){
        int left = 0;
        int right = sum.size()-1;
        int mid;
        int answer = -1;

        while(left <= right){
            mid = (left + right) / 2;

            if(sum.get(mid) <= target){
                left = mid + 1;
                answer =mid;
            }
            else{
                right = mid - 1;
            }
        }
        return answer;
    }
}
