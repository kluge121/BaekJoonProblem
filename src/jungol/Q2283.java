package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2283 {
    static int N;
    static int[][] cost;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N][3];
        cost = new int[N][3];
        for (int i = 0; i < N; i++)
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(a[0]);
            cost[i][1] = Integer.parseInt(a[1]);
            cost[i][2] = Integer.parseInt(a[2]);
        }
        System.out.println(Math.min(dfs(0, 0), Math.min(dfs(0, 1), dfs(0, 2))));
    }

    static int dfs(int index, int color) {
        if (index == N) return 0;
        if (cache[index][color] != Integer.MAX_VALUE) return cache[index][color];

        for (int nextColor = 0; nextColor < 3; nextColor++) {
            if (color == nextColor) continue;
            cache[index][color] = Math.min(cache[index][color], dfs(index + 1, nextColor) + cost[index][color]);
        }
        return cache[index][color];
    }
}
