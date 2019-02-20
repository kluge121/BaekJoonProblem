package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1890 {

    static int N;
    static int[][] map;
    static long countArray[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        countArray = new long[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(countArray[i], -1);
        }

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        System.out.println(dfs(0, 0));
    }

    static long dfs(int x, int y) {

        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        if (countArray[x][y] != -1)
            return countArray[x][y];

        int move = map[x][y];

        if (move == 0) return 0;

        countArray[x][y] = 0;

        if (isValidPoint(x, y + move))
            countArray[x][y] += dfs(x, y + move);

        if (isValidPoint(x + move, y))
            countArray[x][y] += dfs(x + move, y);



        return countArray[x][y];






    }

    static boolean isValidPoint(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
