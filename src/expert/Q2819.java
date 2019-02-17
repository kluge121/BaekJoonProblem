package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2819 {

    static int[][] map;
    static int[] check;
    static int count;
    static int[] xp = {0, 1, 0, -1};
    static int[] yp = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            count = 0;
            map = new int[4][4];
            check = new int[10000000];
            for (int i = 0; i < 4; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(a[j]);
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    search(map[i][j] + "", 1, i, j);
                }
            }
            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void search(String value, int depth, int x, int y) {
        if (depth == 7) {
            if (check[Integer.parseInt(value)] == 0) {
                count++;
                check[Integer.parseInt(value)] = 1;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + xp[i];
            int cy = y + yp[i];
            if (isValidPosition(cx, cy)) {
                search(value + map[cx][cy], depth + 1, cx, cy);
            }
        }
    }

    static boolean isValidPosition(int x, int y) {
        return (x >= 0 && x <= 3) && (y >= 0 && y <= 3);
    }
}
