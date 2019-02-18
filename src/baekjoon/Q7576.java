package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q7576 {

    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static int row;
    static int column;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[1]);
        column = Integer.parseInt(a[0]);

        map = new int[row][column];
        visited = new boolean[row][column];
        queue = new LinkedList<>();

        int goodCount = 0;
        for (int i = 0; i < row; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(b[j]);
                if (map[i][j] == 1) {
                    goodCount++;
                    queue.offer(new Point(i, j, 0));
                }
            }
        }
        if (goodCount == 0) {
            System.out.println(-1);
        }
        int min = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (min != p.count) {
                min = p.count;
            }
            for (int i = 0; i < xDirection.length; i++) {
                int cx = p.x + xDirection[i];
                int cy = p.y + yDirection[i];
                if (isValidPoint(cx, cy) && !visited[cx][cy] && map[cx][cy] != -1) {
                    map[cx][cy] = 1;
                    visited[cx][cy] = true;
                    queue.add(new Point(cx,cy,min+1));
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(min);


    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static boolean isValidPoint(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }


}

