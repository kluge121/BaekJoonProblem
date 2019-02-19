package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1890 {

    static int N;
    static int[][] map;
    static long[][] countArray;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        countArray = new long[N][N];

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        dfs(0, 0, 1);
        System.out.println(countArray[N - 1][N - 1]);
    }

    static void dfs(int x, int y, long preSum) {

        System.out.println(x +" " + y);
        countArray[x][y] += preSum;
        if (map[x][y] == 0) {
            return;
        }
        int move = map[x][y];
        if (isValidPoint(x, y + move)) {
            dfs(x, y + move, countArray[x][y]);

        }
        if (isValidPoint(x + move, y)) {
            dfs(x + move, y, countArray[x][y]);
        }
    }

    static boolean isValidPoint(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
