package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {


    static int[][] map;
    static boolean[][] visit;
    static Queue<Point> queue = new LinkedList<>();
    static int row;
    static int column;
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);

        map = new int[row + 1][column + 1];
        visit = new boolean[row + 1][column + 1];

        for (int i = 1; i <= row; i++) {
            String[] b = br.readLine().split("");
            for (int j = 1; j <= column; j++) {
                map[i][j] = Integer.parseInt(b[j-1]);
            }
        }

        visit[1][1] = true;
        queue.add(new Point(1, 1, 1));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == row && p.y == column) {
                System.out.println(p.depth);
            }
            for (int i = 0; i < 4; i++) {
                int cx = p.x + xDirection[i];
                int cy = p.y + yDirection[i];
                if (isValidPoint(cx, cy) && !visit[cx][cy] && map[cx][cy]==1) {
                    queue.add(new Point(cx, cy, p.depth + 1));
                    visit[cx][cy] = true;
                }
            }

        }


    }

    static boolean isValidPoint(int x, int y) {
        return x > 0 && x <= row && y > 0 && y <= column;
    }

    static class Point {
        int x;
        int y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}