import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if(line.isEmpty()) break;

            arr.add(Integer.parseInt(line));
        }

        solve(0, arr.size()-1);

    }

    static void solve(int start, int end) {
        if(start > end) return;

        int root = arr.get(start);
        int mid = end + 1;

        for (int i = start + 1; i <= end; i++) {
            if(arr.get(i) > root) {
                mid = i;
                break;
            }
        }

        solve(start+1, mid-1);
        solve(mid, end);

        System.out.println(root);
    }
}
