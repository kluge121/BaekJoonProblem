package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1868 {

    static int N;
    static int[][] map;
    static boolean[][] check;
    static final int BOOM = -1;
    static final int NONE = -2;
    static int[] rowD = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] columnD = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static Queue<Point> queue;
    static  Queue<Point> badQueue;
    static int time = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            queue = new LinkedList<>();
            badQueue = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            check = new boolean[N][N];
            time = 0;
            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    if (a[j].equals(".")) {
                        map[i][j] = NONE;
                    } else if (a[j].equals("*")) {
                        map[i][j] = BOOM;
                        check[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == NONE) {
                        Point point;
                        if (getSafeCount(i, j) > 0) {
                            point = new Point(i, j, true);
                            queue.add(point);
                        } else {
                            point = new Point(i, j, false);
                            badQueue.add(point);
                        }
                    }
                }
            }


            while (!queue.isEmpty()) {
                Point p = queue.poll();
                if (check[p.x][p.y])
                    continue;

                if (isGameEnd()) {
                    badQueue.clear();
                    break;
                }
                time++;
                chainCheck(p.x, p.y);
            }

            while (!badQueue.isEmpty()) {
                Point p = badQueue.poll();
                if (!check[p.x][p.y])
                    time++;

            }

            out[t] = String.format("#%d %d", t+1,time);
        }

        for (String a : out) {
            System.out.println(a);
        }

    }

    static boolean isGameEnd() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j])
                    return false;
            }
        }

        return true;
    }

    static int getSafeCount(int row, int column) {

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int tr = row + rowD[i];
            int tc = column + columnD[i];
            if (isValid(tr, tc) && map[tr][tc] == BOOM) {
                return -1;
            } else if (isValid(tr, tc) && map[tr][tc] == NONE) {
                count++;
            }
        }
        return count;

    }

    static boolean isValid(int row, int column) {
        return row >= 0 && row < N && column >= 0 && column < N;
    }

    static void chainCheck(int row, int column) {

        check[row][column] = true;
        if (getSafeCount(row, column) != -1) {
            for (int i = 0; i < rowD.length; i++) {
                int tr = row + rowD[i];
                int tc = column + columnD[i];
                if (isValid(tr, tc) && !check[tr][tc]) {
                    chainCheck(tr, tc);
                }
            }
        }

    }

    static class Point {
        int x, y;
        boolean chainCheck;

        public Point(int x, int y, boolean chainCheck) {
            super();
            this.x = x;
            this.y = y;
            this.chainCheck = chainCheck;
        }

    }

}
