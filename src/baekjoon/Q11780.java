package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11780 {

    static int[][] adj;
    static int[][] cost;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());


        adj = new int[N + 1][N + 1];
        cost = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < Q; i++) {
            String[] a = br.readLine().split(" ");
            int s = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            int c = Integer.parseInt(a[2]);
            adj[s][e] = Math.min(adj[s][e], c);
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(i==k)continue;
                for (int j = 1; j <= N; j++) {
                    if(i==j)continue;
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][i]);
                }
            }
        }

    }
}
