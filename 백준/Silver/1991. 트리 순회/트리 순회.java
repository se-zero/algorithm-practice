import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] left = new char[26];;
    static char[] right = new char[26];;
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char node = st.nextToken().charAt(0);
            char leftNode = st.nextToken().charAt(0);
            char rightNode = st.nextToken().charAt(0);

            left[node - 'A'] = leftNode;
            right[node - 'A'] = rightNode;
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');
        sb.append("\n");

        System.out.println(sb);

    }

    static void preorder(char node) {
        if (node == '.') return;

        sb.append(node);
        preorder(left[node - 'A']);
        preorder(right[node - 'A']);
    }

    static void inorder(char node) {
        if (node == '.') return;

        inorder(left[node - 'A']);
        sb.append(node);
        inorder(right[node - 'A']);
    }

    static void postorder(char node) {
        if (node == '.') return;

        postorder(left[node - 'A']);
        postorder(right[node - 'A']);
        sb.append(node);
    }


}
