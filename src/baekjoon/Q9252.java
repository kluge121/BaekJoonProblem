package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9252 {


    static int[][] cache;
    static boolean[][] visit;
    static Point[][] backTracking;

    static String a;
    static String b;

    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();

        cache = new int[a.length()][b.length()];
        visit = new boolean[a.length()][b.length()];
        backTracking = new Point[a.length()][b.length()];
        search(0, 0);
        System.out.println(max);
        Point point = backTracking[0][0];
        while (point != null) {
            if (point.check) {
                System.out.print(a.charAt(point.a));
            }
            point = backTracking[point.a][point.b];
        }
    }

    static int search(int aa, int bb) {

        if (aa > a.length() - 1 || bb > b.length() - 1) return 0;

        if (visit[aa][bb]) {
            return cache[aa][bb];
        }
        visit[aa][bb] = true;
        int count = 0;

        if (a.charAt(aa) == b.charAt(bb)) {
            count = search(aa + 1, bb + 1) + 1;
            backTracking[aa][bb] = new Point(aa + 1, bb + 1, true);
        } else {

            int value1 = search(aa + 1, bb);
            int value2 = search(aa, bb + 1);

            if (value1 > value2) {
                backTracking[aa][bb] = new Point(aa, bb + 1, false);
                count = value1;
            } else {
                backTracking[aa][bb] = new Point(aa + 1, bb, false);
                count = value2;
            }
        }
        max = Math.max(count, max);
        return cache[aa][bb] = count;
    }

    static class Point {
        int a, b;
        boolean check;

        public Point(int a, int b, boolean check) {
            this.a = a;
            this.b = b;
            this.check = check;
        }
    }
}



