package baekjoon;

import java.util.Scanner;

public class Q2579 {

    static int[] adj;
    static int[] cache;
    static int stairCount;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        stairCount = sc.nextInt();
        adj = new int[stairCount + 1];
        cache = new int[stairCount + 1];
        for (int i = 1; i <= stairCount; i++) {
            adj[i] = sc.nextInt();
        }

        cache[1] = adj[1];
        cache[2] = Math.max(adj[2], adj[1] + adj[2]);
        cache[3] = Math.max(adj[1] + adj[3], adj[2] + adj[3]);

        search(4);
        System.out.println(cache[stairCount]);
    }

    static void search(int n) {
        cache[n] = Math.max(cache[n - 2] + adj[n], cache[n - 3] + adj[n - 1] + adj[n]);
        if (n >= stairCount) return;
        search(n + 1);
    }
}

