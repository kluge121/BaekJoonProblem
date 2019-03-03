package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1462 {

    static int max = 0;
    static int[][] map;
    static int row;
    static int column;
    static boolean visited[][];
    static Queue<Point> queue;
    static ArrayList<Point> lists;
    static int[] xd = {0, 1, 0, -1};
    static int[] yd = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);
        lists = new ArrayList<>();
        map = new int[row][column];
        visited = new boolean[row][column];
        queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            String b = br.readLine();
            for (int j = 0; j < column; j++) {
                map[i][j] = b.charAt(j);
                if (map[i][j] == 'L') {
                    lists.add(new Point(i,j,0));
                }
            }
        }

        for(Point p : lists){
            search(new Point(p.x, p.y, p.level));
        }
        System.out.println(max);
    }


    static void search(Point startPoint) {
        visited = new boolean[row][column];
        queue = new LinkedList<>();
        visited[startPoint.x][startPoint.y] = true;

        queue.add(startPoint);

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            max = Math.max(p.level, max);
            for (int i = 0; i < 4; i++) {
                int cx = p.x + xd[i];
                int cy = p.y + yd[i];
                if (cx >= 0 && cx < row && cy >= 0 && cy < column && !visited[cx][cy] && map[cx][cy] == 'L') {
                    visited[cx][cy] = true;
                    queue.add(new Point(cx, cy, p.level + 1));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int level;

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}
