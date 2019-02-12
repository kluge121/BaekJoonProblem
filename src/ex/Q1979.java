package ex;

import java.util.Scanner;

public class Q1979 {

    static int[][] map;
    static int mapSize;
    static int kSize;
    static String[] out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            mapSize = sc.nextInt();
            kSize = sc.nextInt();
            map = new int[mapSize][mapSize];
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {

                    if (map[i][j] == 1) {

                        if (!isValidSpace(i - 1, j)) {
                            for (int k = 1; k <= kSize; k++) {
                                if (k == kSize && !isValidSpace(i + k, j)) count++;
                                else if (k != kSize && !isValidSpace(i + k, j)) break;
                            }
                        }
                        if (!isValidSpace(i, j - 1)) {
                            for (int k = 1; k <= kSize; k++) {
                                if (k == kSize && !isValidSpace(i, j + k)) count++;
                                else if (k != kSize && !isValidSpace(i, j + k)) break;
                            }
                        }
                    }
                }
            }
            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static boolean isValidSpace(int row, int column) {
        return row < mapSize && row >= 0 && column < mapSize && column >= 0 && map[row][column] == 1;
    }
}
