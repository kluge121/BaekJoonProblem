package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1325 {

    static boolean[][] adj;
    static int cache[];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        adj = new boolean[N + 1][N + 1];
        cache = new int[N+1];
        for (int i = 0; i < M; i++) {
            String[] b = br.readLine().split(" ");
            int n1 = Integer.parseInt(b[0]);
            int n2 = Integer.parseInt(b[1]);
            adj[n1][n2] = true;
        }

    }

    static void dfs(int index) {


        for (int i = 1; i<=N; i++){

        }

    }
}
