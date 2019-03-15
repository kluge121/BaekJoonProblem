package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q16947 {

    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> candidate;
    static int[] discover;
    static boolean[] isCycle;
    static boolean[] isFinish;
    static int[] out;
    static int seq;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        discover = new int[N + 1];
        isCycle = new boolean[N + 1];
        isFinish = new boolean[N + 1];
        out = new int[N + 1];
        candidate = new ArrayList<>();
        seq = 1;

        //문제 정보 입력
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int s = Integer.parseInt(a[0]);
            int e = Integer.parseInt(a[1]);
            if (adj[s] == null)
                adj[s] = new ArrayList<>();
            if (adj[e] == null)
                adj[e] = new ArrayList<>();
            adj[s].add(e);
            adj[e].add(s);
        }
        discover = new int[N + 1];
        seq = 1;


        for (int i = 1; i <= N; i++) {
            if (discover[i] == 0)
                makeSpanningTree(i);
        }


        for (int i : candidate) {
            for (int j : adj[i]) {
                if (!isFinish[j]) {
                    dfs(j, 1);
                }
            }
        }

        for (int i = 1; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }


    static void dfs(int index, int depth) {
        if (isCycle[index]) return;
        out[index] = depth;
        isFinish[index] = true;
        if (adj[index] != null) {
            for (int i : adj[index]) {
                if (!isFinish[i]) {
                    dfs(i, depth + 1);
                }
            }
        }
    }

    static void makeSpanningTree(int index) {
        if (discover[index] == 0) {
            discover[index] = seq++;
        }
        ArrayList<Integer> indexAdj = adj[index];

        for (int i : indexAdj) {
            if (discover[i] == 0) {
                makeSpanningTree(i);
            } else if (discover[i] > discover[index]) {
                isCycle[i] = true;
                isCycle[index] = true;
                paintCycle(index, i);
            }
        }
    }

    static void paintCycle(int startIndex, int endIndex) {

        boolean[] tmpVisit = new boolean[N + 1];
        int tmp = startIndex;

        tmpVisit[startIndex] = true;
        tmpVisit[endIndex] = true;

        if (adj[startIndex].size() > 2) {
            candidate.add(startIndex);
        }
        if (adj[endIndex].size() > 2) {
            candidate.add(endIndex);
        }

        while (tmp != endIndex) {

            if (adj[tmp].size() > 2) {
                candidate.add(tmp);
            }
            for (int i : adj[tmp]) {
                if (!tmpVisit[i] && discover[i] > discover[startIndex] && discover[i] < discover[endIndex] && !isFinish[i]) {
                    isCycle[i] = true;
                    isFinish[i] = true;
                    tmp = i;
                    break;
                } else if (i == endIndex) {
                    tmp = endIndex;
                }

            }
        }


    }


}

