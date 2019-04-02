package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3234 {


    static int N;
    static int[] score;
    static int count;
    static boolean[] visit;
    static int[] per;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            per = new int[N];
            visit = new boolean[N];
            score = new int[N];
            String[] a = br.readLine().split(" ");
            count = 0;
            for (int i = 0; i < N; i++) score[i] = Integer.parseInt(a[i]);

            dfs2(0);
            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static int dfs(int r, int l, int d) {
        if (r > l) return 0;
        if (d == N) return 1;
        return dfs(r, l + score[per[d]], d + 1) + dfs(r + score[per[d]], l, d + 1);
    }
    static void dfs2(int d) {
        if (d == N) count += dfs(0, score[per[0]], 1);
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                per[d] = i;
                dfs2(d + 1);
                visit[i] = false;
            }
        }
    }
}
