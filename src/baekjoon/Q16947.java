package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q16947 {


    static ArrayList<Integer>[] adj;
    static int[] discover;
    static boolean[] isCycle;
    static int seq;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        discover = new int[N + 1];
        isCycle = new boolean[N + 1];
        seq = 1;

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


        for (int i = 1; i <= N; i++) {
            discover = new int[N + 1];
            seq = 1;
            makeSpanningTree(i);
        }

        System.out.println(Arrays.toString(isCycle));
        System.out.println(Arrays.toString(discover));

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
                System.out.println("역방향");
                //역방향 찾았으면 역방향
                // i ...... index 가 사이클임당
                isCycle[i] = true;
                isCycle[index] = true;

            } else if (discover[i] < discover[index]) {
                //순방향
            } else {
                //교차간선

            }


        }

    }


}

