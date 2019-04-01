package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3289 {
    static int[] rank;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("#%d ", t + 1));
            String[] a = br.readLine().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            root = new int[n + 1];
            rank = new int[n + 1];
            Arrays.fill(rank, 1);
            for (int i = 1; i <= n; i++) {
                root[i] = i;
            }
            for (int i = 0; i < m; i++) {

                String[] b = br.readLine().split(" ");
                int op = Integer.parseInt(b[0]);
                int t1 = Integer.parseInt(b[1]);
                int t2 = Integer.parseInt(b[2]);

                if (op == 0)
                    union(t1, t2);
                else if (op == 1) {
                    if (find(t1) == find(t2)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }
            out[t] = sb.toString();
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        int big = rank[aa] > rank[bb] ? aa : bb;
        int small = rank[aa] > rank[bb] ? bb : aa;
        if (aa != bb) {
            root[small] = big;
            rank[big] += rank[small];
        }
    }
    static int find(int a) {
        int parent = root[a];
        if (parent == a) return parent;
        else return find(parent);
    }

}


