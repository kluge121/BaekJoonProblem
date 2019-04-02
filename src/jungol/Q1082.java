package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1082 {

    static char[][] map;
    static int row, col;
    static Point point;
    static Point endPoint;
    static ArrayList<Point> fireList;
    static boolean[][] visit;

    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[0]);
        col = Integer.parseInt(a[1]);
        queue = new LinkedList<>();

        map = new char[row][col];
        visit = new boolean[row][col];
        fireList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            char[] b = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = b[j];
                if (b[j] == '*') {
                    fireList.add(new Point(i, j, 0));
                } else if (b[j] == 'S') {
                    point = new Point(i, j, 0);
                } else if (b[j] == 'D') {
                    endPoint = new Point(i, j, 0);
                }
            }
        }

        int prev = -1;
        visit[point.r][point.c] = true;
        queue.add(point);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.r == endPoint.r && p.c == endPoint.c) {
                System.out.println(p.level);
                return;
            }

            if (p.level != prev) {
                //불장난
                ArrayList<Point>tmpFire = new ArrayList<>();
                for (Point fire : fireList) {
                    for (int i = 0; i < 4; i++) {
                        int cr = fire.r + rowD[i];
                        int cc = fire.c + colD[i];
                        if (isRange(cr, cc) && map[cr][cc] != '*' && map[cr][cc] != 'X' && map[cr][cc] != 'D') {
                            map[cr][cc] = '*';
                            tmpFire.add(new Point(cr, cc, 0));
                        }
                    }
                }
                fireList.addAll(tmpFire);
                prev=p.level;
            }

            for (int i = 0; i < 4; i++) {
                int cr = p.r + rowD[i];
                int cc = p.c + colD[i];
                if (isRange(cr, cc) && !visit[cr][cc] && map[cr][cc] != '*' && map[cr][cc] != 'X') {
                    visit[cr][cc] = true;
                    queue.add(new Point(cr, cc, p.level + 1));
                }
            }


        }
        System.out.println("impossible");
    }


    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }

    static class Point {
        int r, c, level;

        public Point(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }

}
