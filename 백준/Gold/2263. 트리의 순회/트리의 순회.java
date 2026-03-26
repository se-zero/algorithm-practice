import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] inorder;
    static int[] postorder;
    static Map<Integer, Integer> indexMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            indexMap.put(inorder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        solve(0,n-1,0,n-1);

        System.out.println(sb);
    }

    static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return;
        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = indexMap.get(root);
        int leftSize = rootIndex - inStart;

        solve(inStart, rootIndex-1, postStart, postStart + leftSize - 1);
        solve(rootIndex+1, inEnd, postStart + leftSize, postEnd-1);
    }


}
