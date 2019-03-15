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
    static ArrayList<Point> candidateList;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);
        map = new int[row][column];

        candidateList = new ArrayList<>();
        vList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                int value = Integer.parseInt(b[j]);
                if (value == 2) {
                    vList.add(new Point(i, j));
                } else if (value == 0) {
                    candidateList.add(new Point(i, j));
                }
                map[i][j] = value;
            }
        }

        int max = 0;

        for (int i = 0; i < candidateList.size() - 3; i++) {
            for (int j = i + 1; j < candidateList.size() - 2; j++) {
                for (int k = j + 1; k < candidateList.size() - 1; k++) {
                    int[][] tmpMap = new int[row][column];

                    for (int r = 0; r < row; r++) {
                        for (int c = 0; c < column; c++) {
                            tmpMap[r][c] = map[r][c];
                        }
                    }

                    max = Math.max(max, search(tmpMap, candidateList.get(i), candidateList.get(j), candidateList.get(k)));
                }
            }

        }
        System.out.println(max);
    }

    static int search(int[][] tmpMap, Point p1, Point p2, Point p3) {


        boolean[][] visit = new boolean[row][column];
        tmpMap[p1.row][p1.column] = 1;
        tmpMap[p2.row][p2.column] = 1;
        tmpMap[p3.row][p3.column] = 1;


        Queue<Point> queue = new LinkedList<>(vList);

        while (!queue.isEmpty()) {
            Point p = queue.poll();


            for (int i = 0; i < 4; i++) {

                int cr = p.row + dRow[i];
                int cc = p.column + dCol[i];

                if (isValid(cr, cc) && tmpMap[cr][cc] == 0 && !visit[cr][cc]) {
                    queue.add(new Point(cr, cc));
                    tmpMap[cr][cc] = 2;
                    visit[cr][cc] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
//                System.out.print(tmpMap[i][j]+" ");
                if (tmpMap[i][j] == 0) {
                    count++;
                }
            }
//            System.out.println();
        }
//        System.out.println("-------------------------------");
        return count;
    }


    static class Point {
        int row, column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < column;
    }

}
