package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Q2458 {

    static ArrayList<Integer>[] adj1;
    static ArrayList<Integer>[] adj2;
    static int[] check;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        check = new int[N + 1];
        adj1 = new ArrayList[N + 1];
        adj2 = new ArrayList[N + 1];
        for (int i = 0; i < M; i++) {
            String[] b = br.readLine().split(" ");
            int s1 = Integer.parseInt(b[0]);
            int s2 = Integer.parseInt(b[1]);

            if (adj1[s1] == null)
                adj1[s1] = new ArrayList<>();
            if (adj2[s2] == null)
                adj2[s2] = new ArrayList<>();

            adj1[s1].add(s2);
            adj2[s2].add(s1);
        }
        for (int i = 1; i <= N; i++) {
            if (adj1[i] != null) {
                visit = new boolean[N + 1];
                check[i]--;
                dfs1(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (adj2[i] != null) {
                visit = new boolean[N + 1];
                check[i]--;
                dfs2(i);
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (check[i] == N-1) count++;
        }
        System.out.println(count);
    }
    static void dfs1(int index) {
        check[index]++;
        visit[index] = true;
        if (adj1[index] != null) {
            for (int next : adj1[index]) {
                if (!visit[next])
                    dfs1(next);
            }
        }
    }
    static void dfs2(int index) {
        check[index]++;
        visit[index] = true;
        if (adj2[index] != null) {
            for (int next : adj2[index]) {
                if (!visit[next])
                    dfs2(next);
            }
        }
    }
}
