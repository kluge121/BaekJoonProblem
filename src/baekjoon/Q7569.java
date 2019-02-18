package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q7569 {

    static int row;
    static int column;
    static int height;

    static int[][][] map;
    static Queue<Point> queue;

    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static int[] zDirection = {-1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[1]);
        column = Integer.parseInt(a[0]);
        height = Integer.parseInt(a[2]);

        map = new int[height][row][column];
        queue = new LinkedList<>();

        int min = 1;
        int goodCount = 0;
        int blockCount = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                String[] b = br.readLine().split(" ");
                for (int k = 0; k < column; k++) {
                    map[i][j][k] = Integer.parseInt(b[k]);
                    if (map[i][j][k] == 1) {
                        goodCount++;
                        queue.offer(new Point(i, j, k, 0));
                    } else if (map[i][j][k] == -1) {
                        blockCount++;
                    }
                }
            }
        }


        if (goodCount + blockCount == row * column * height) {
            System.out.println(0);
            return;
        }

        if (goodCount == 0) {
            System.out.println(-1);
            return;
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.count != min)
                min = p.count;


            //수직 세팅
            for (int i = 0; i < 3; i++) {
                int cz = p.z + zDirection[i];
                int cx = p.x;
                int cy = p.y;
                if (isValidPoint(cz, cx, cy) && map[cz][cx][cy] == 0) {
                    queue.offer(new Point(cz, cx, cy, min + 1));
                    map[cz][cx][cy] = 1;
                }
            }


            //평면 세팅
            for (int i = 0; i < 4; i++) {
                int cz = p.z;
                int cx = p.x + xDirection[i];
                int cy = p.y + yDirection[i];
                if (isValidPoint(cz, cx, cy) && map[cz][cx][cy] == 0) {
                    queue.offer(new Point(cz, cx, cy, min + 1));
                    map[cz][cx][cy] = 1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(min);


    }

    static boolean isValidPoint(int z, int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column && z >= 0 && z < height;
    }

    static class Point {
        int z;
        int x;
        int y;
        int count;

        public Point(int z, int x, int y, int count) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
