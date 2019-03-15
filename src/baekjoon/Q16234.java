package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q16234 {

    static int[][] map;
    static int[][] tmpMap;
    static boolean[][] isOpenCheck;
    static int sum;
    static boolean[][] visit;
    static int N, L, R;

    static int[] rowD = {1, 0, -1, 0};
    static int[] columnD = {0, 1, 0, -1};
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        N = Integer.parseInt(a[0]);
        L = Integer.parseInt(a[1]);
        R = Integer.parseInt(a[2]);

        map = new int[N][N];
        tmpMap=new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(b[j]);
            }
        }


        int count = 0;
        isOpenCheck = new boolean[N][N];
        visit = new boolean[N][N];


        while (true) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }
            visit = new boolean[N][N];
            isOpenCheck = new boolean[N][N];
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    int tmpCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int cr = i + rowD[d];
                        int cc = j + columnD[d];
                        if (isValid(cr, cc)) {
                            int dif = Math.abs(map[cr][cc] - map[i][j]);
                            if (!visit[cr][cc] && dif >= L && dif <= R) {
                                list = new ArrayList<>();
                                sum = 0;
                                tmpCount += dfs(new Point(i, j));
                                break;
                            }
                        }
                    }
                    if (tmpCount > 0) {
                        int avg = sum / tmpCount;
                        flag = false;
                        for (Point p : list) {
                            tmpMap[p.row][p.column] = avg;
                        }
                    }


                }
            }

            if (flag) break;
            else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] = tmpMap[i][j];
                    }
                }
                count++;
            }


        }

        System.out.println(count);
    }


    static boolean isValid(int row, int column) {
        return row >= 0 && column >= 0 && row < N && column < N;
    }

    static class Point {
        int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static int dfs(Point p) {
        isOpenCheck[p.row][p.column] = true;
        visit[p.row][p.column] = true;
        sum += map[p.row][p.column];
        list.add(p);

        int tmpCount = 0;

        for (int i = 0; i < 4; i++) {
            int cr = p.row + rowD[i];
            int cc = p.column + columnD[i];
            if (isValid(cr, cc)) {
                int dif = Math.abs(map[cr][cc] - map[p.row][p.column]);
                if (!visit[cr][cc] && dif >= L && dif <= R) {
                    tmpCount += dfs(new Point(cr, cc));
                }
            }
        }
        return tmpCount + 1;
    }

}
