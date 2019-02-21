package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1325 {

    static int discover[];
    static boolean visit[];
    static int count = 1;

    static boolean[][] adj;
    static int cache[];

    static int N;
    static int M;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);

        discover = new int[N + 1];
        visit = new boolean[N + 1];

        adj = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String[] b = br.readLine().split(" ");
            int n1 = Integer.parseInt(b[0]);
            int n2 = Integer.parseInt(b[1]);
            adj[n2][n1] = true;
        }
//        cache = new int[N + 1];
//        visit = new boolean[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            dfs(i);
//            max = Math.max(cache[i], max);
//        }
//        for (int i = 1; i <= N; i++) {
//            if (max == cache[i])
//                System.out.print(i + " ");
//        }

    }

    static int dfs(int index) {
        if (visit[index]) return cache[index];

        for (int i = 1; i <= N; i++) {
            if (adj[index][i]) {
                cache[index] += 1;
                cache[index] += dfs(i);
            }
        }
        visit[index] = true;
        return cache[index];
    }


    static void findSpanningTree(int x) {

        discover[x] = count++;
        for (int i = 1 ; i <=N; i++){
            if(!visit[i] && adj[x][i] ){
                findSpanningTree(i);
            }

        }


    }

}



















