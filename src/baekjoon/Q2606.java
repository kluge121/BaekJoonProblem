package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q2606 {

    static boolean[][] adj;
    static boolean[] visit;
    static int N;
    static int count = 0;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        adj = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < T; i++) {
            String[] a = br.readLine().split(" ");
            int i1 = Integer.parseInt(a[0]);
            int i2 = Integer.parseInt(a[1]);
            adj[i1][i2] = true;
            adj[i2][i1] = true;
        }
        visit[1] = true;
        bfs(1);

        System.out.println(count);


    }

    static void bfs(int value) {
        for (int i = 2; i <= N; i++) {
            if (!visit[i] && adj[value][i]) {
                count++;
                visit[i] = true;
                bfs(i);
            }
        }

    }

}

