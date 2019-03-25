package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1681 {

    static int N;
    static int min;
    static int[][] map;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(b[j - 1]);
            }
        }
        visit[1] = true;
        dfs(1, 0);
        System.out.println(min);
    }
    static void dfs(int index, int cost) {

        if (cost > min) return;

        if (allCheck()) {
            if (map[index][1] != 0) {
                min = Math.min(min, cost + map[index][1]);
            } else {
                return;
            }
        }
        for (int i = 2; i <= N; i++) {
            if (!visit[i] && map[index][i] > 0) {
                visit[i] = true;
                dfs(i, cost + map[index][i]);
                visit[i] = false;
            }
        }
    }
    static boolean allCheck() {
        boolean b = true;
        for (int i = 2; i <= N; i++) {
            if (!visit[i]) {
                b = false;
                break;
            }
        }
        return b;
    }
}
