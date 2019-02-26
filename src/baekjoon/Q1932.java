package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Q1932 {
    static int n;
    static int[][] map;
    static int cache[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        cache = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < a.length; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        search(0, 0, 0);
        System.out.println(cache[0][0]);
    }
    static int search(int d, int y, int sum) {
        if (d == n) return 0;
        if (visit[d][y]) return cache[d][y];
        visit[d][y] = true;
        int current = map[d][y];
        int value1 = search(d + 1, y, sum) + current;
        int value2 = search(d + 1, y + 1, sum) + current;
        return cache[d][y] = Math.max(value1, value2);
    }

}
