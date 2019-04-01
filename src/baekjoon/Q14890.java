package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14890 {

    static int[][] map;
    static int N, X;
    static int count;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = 0;
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        X = Integer.parseInt(a[1]);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(b[j]);
            }
        }

        //행 탐색
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            int prev = map[i][0];
            for (int j = 1; j < N; j++) {
                if (prev > map[i][j]) {
                    if (isRange(i, j + X - 1)) {
                        for (int k = 0; k < X; k++) {
                            if (map[i][j + k] != prev - 1) {
                                flag = true;
                                break;
                            }
                        }
                    } else {
                        flag = true;
                    }
                    if (flag) break;
                    else for (int k = 0; k < X; k++) check[i][j + k] = true;

                } else if (prev < map[i][j]) {

                    if (isRange(i, j - X)) {
                        for (int k = 1; k <= X; k++) {
                            if (check[i][j - k] || map[i][j] != (prev + 1)) {
                                flag = true;
                                break;
                            }
                        }
                    } else {
                        flag = true;
                    }
                    if (flag) break;
                    else for (int k = 1; k <= X; k++) check[i][j - k] = true;

                }
                prev = map[i][j];
            }
            if (!flag) {
                count++;
            }
        }

        //열 탐색
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            int prev = map[0][i];
            for (int j = 1; j < N; j++) {

                if (prev > map[j][i]) {

                    if (isRange(j + X - 1, i)) {
                        for (int k = 0; k < X; k++) {
                            if (map[j + k][i] != prev - 1) {
                                flag = true;
                                break;
                            }
                        }
                    } else {
                        flag = true;
                    }
                    if (flag) break;
                    else for (int k = 0; k < X; k++) check[j + k][i] = true;

                } else if (prev < map[j][i]) {
                    if (isRange(j - X, i)) {
                        for (int k = 1; k <= X; k++) {
                            if (check[j - k][i] || map[j][i] != (prev + 1)) {
                                flag = true;
                                break;
                            }
                        }
                    } else {

                        flag = true;
                    }
                    if (flag) break;
                    else for (int k = 1; k <= X; k++) check[j - k][i] = true;
                }
                prev = map[j][i];
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);

    }

    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

}
