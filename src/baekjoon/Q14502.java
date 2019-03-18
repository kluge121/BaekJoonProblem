package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q14502 {


    static int row;
    static int column;
    static int[][] map;

    static ArrayList<Point> vList;
    static ArrayList<Point> candidate;

    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);
        map = new int[row][column];
        vList = new ArrayList<>();
        candidate = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                int value = Integer.parseInt(b[j]);
                map[i][j] = value;
                if (value == 2)
                    vList.add(new Point(i, j));
                else if (value == 0) {
                    candidate.add(new Point(i, j));
                }
            }
        }

        int max = 0;

        for (int i = 0; i < candidate.size() - 2; i++) {
            for (int j = i + 1; j < candidate.size() - 1; j++) {
                for (int k = j + 1; k < candidate.size(); k++) {

                    int[][] tmpMap = new int[row][column];
                    for (int r = 0; r < row; r++) {
                        for (int c = 0; c < column; c++) {
                            tmpMap[r][c] = map[r][c];
                        }
                    }
                    max = Math.max(max, search(tmpMap, candidate.get(i), candidate.get(j), candidate.get(k)));
                }
            }
        }

        System.out.println(max);
    }

    static int search(int[][] tmpMap, Point p1, Point p2, Point p3) {

        Queue<Point> queue = new LinkedList<>(vList);
        tmpMap[p1.row][p1.column] = 1;
        tmpMap[p2.row][p2.column] = 1;
        tmpMap[p3.row][p3.column] = 1;

        boolean[][] visit = new boolean[row][column];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < rowD.length; i++) {
                int cr = p.row + rowD[i];
                int cc = p.column + colD[i];

                if (isValid(cr, cc) && tmpMap[cr][cc] == 0 && !visit[cr][cc]) {
                    tmpMap[cr][cc] = 2;
                    visit[cr][cc] = true;
                    queue.add(new Point(cr, cc));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (tmpMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;

    }

    static boolean isValid(int r, int c) {

        return r >= 0 && r < row && c >= 0 && c < column;
    }

    static class Point {
        int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
