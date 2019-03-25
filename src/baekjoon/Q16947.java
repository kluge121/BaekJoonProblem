package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Q16947 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] discover;
    static Queue<Integer> candidate;
    static int[] out;
    static int seq;
    static boolean[] isCycle;
    static boolean[] visit;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        discover = new int[N + 1];
        isCycle = new boolean[N + 1];
        visit = new boolean[N + 1];
        out = new int[N + 1];
        seq = 1;
        candidate = new LinkedList<>();
        Arrays.fill(discover, -1);
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int s = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            if (adj[s] == null) {
                adj[s] = new ArrayList<>();
            }
            if (adj[e] == null) {
                adj[e] = new ArrayList<>();
            }
            adj[s].add(e);
            adj[e].add(s);
        }
        makeSpanningTree(1, -1);
        while (!candidate.isEmpty()) {
            int n = candidate.poll();
            for (int i : adj[n]) {
                if (isCycle[i]) continue;
                dfs(i, 1);
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(out[i] + " ");
        }
    }

    static boolean makeSpanningTree(int n, int prev) {

        if (discover[n] == -1) {
            discover[n] = seq++;
        }
        for (int next : adj[n]) {
            if (discover[next] == -1) {
                if (makeSpanningTree(next, n) && discover[start] < discover[n] && discover[end] > discover[n]) {
                    isCycle[n] = true;
                    if (adj[n].size() > 2)
                        candidate.add(n);
                    return true;
                }
            } else if (prev != next && discover[n] > discover[next]) {
                isCycle[n] = true;
                isCycle[next] = true;
                start = next;
                end = n;
                if (adj[n].size() > 2)
                    candidate.add(n);
                if (adj[next].size() > 2)
                    candidate.add(next);
                return true;
            }
        }
        return false;
    }

    static void dfs(int index, int d) {
        out[index] = d;
        visit[index] = true;
        if (adj[index] != null) {
            for (int i : adj[index]) {
                if (!isCycle[i] && !visit[i]) {
                    dfs(i, d + 1);
                }
            }
        }
    }
}