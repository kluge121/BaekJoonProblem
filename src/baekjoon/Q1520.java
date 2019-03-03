package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1520 {

    static int[][] map;
    static boolean[][] visit;
    static int[][] cache;
    static int row;
    static int column;
    static int[] xd = {0, 1, 0, -1};
    static int[] yd = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);

        map = new int[row][column];
        cache = new int[row][column];
        visit = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(b[j]);
            }
        }
        bfs(0,0);
        System.out.println(cache[0][0]);
    }
    static int bfs(int x, int y) {

        if (x == row - 1 && y == column - 1) return 1;

        if (visit[x][y]) return cache[x][y];
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + xd[i];
            int cy = y + yd[i];

            if (moveCheck(cx, cy) && map[x][y] > map[cx][cy]) {
                cache[x][y] += bfs(cx, cy);
            }
        }
        return cache[x][y];
    }
    static boolean moveCheck(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }
}
