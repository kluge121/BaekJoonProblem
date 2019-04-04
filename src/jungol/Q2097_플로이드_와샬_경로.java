package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2097_플로이드_와샬_경로 {

    static int[][] map;
    static int[][] mid;
    final static int INF = 99999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);
        map = new int[N + 1][N + 1];
        mid = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    map[i][j] = INF;
                } else {
                    map[i][j] = Integer.parseInt(b[j - 1]);
                }
            }
        }


        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        mid[i][j] = k;
                    }

                }
            }
        }
        System.out.println(map[1][M]);
        ArrayList<Integer> path = new ArrayList<>();
        findPath(1, M, path);
        for (int i : path) {
            System.out.print(i + " ");
        }

    }

    static void findPath(int i, int j, ArrayList<Integer> path) {
        if (mid[i][j] == 0) {
            path.add(i);
            if (i != j) {
                path.add(j);
            }
        } else {
            int k = mid[i][j];
            findPath(i, k, path);
            path.remove(path.size() - 1);
            findPath(k, j, path);
        }


    }

}
