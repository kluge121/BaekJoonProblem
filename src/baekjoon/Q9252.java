package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9252 {

    static int[][] cache;
    static boolean[][] visit;
    static Point[][] backtracking;

    static String a;
    static String b;
    static Point startPoint = null;

    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();
        cache = new int[a.length()][b.length()];
        visit = new boolean[a.length()][b.length()];
        backtracking = new Point[a.length()][b.length()];
        search(0, 0);
        System.out.println(max);


        for (int i = 0; i < max; i++) {
            if (startPoint.check) {
                System.out.print(a.charAt(startPoint.a));
            }
            startPoint = backtracking[startPoint.a][startPoint.b];
        }
    }

    static int search(int aa, int bb) {
        if (aa > a.length() - 1 || bb > b.length() - 1) return 0;
        if (visit[aa][bb]) return cache[aa][bb];
        visit[aa][bb] = true;
        int count = 0;


        if (a.charAt(aa) == b.charAt(bb)) {
            int tmp = search(aa + 1, bb + 1);
            if (count < tmp) {
                backtracking[aa][bb] = new Point(aa + 1, bb + 1, true);
                count = tmp;
            }
            count++;
        } else {
            int tmp1 = search(aa, bb + 1);
            int tmp2 = search(aa + 1, bb);
            if (tmp1 > tmp2) {
                if (count < tmp1) {
                    backtracking[aa][bb] = new Point(aa, bb + 1, false);
                    count = tmp1;
                }
            } else {
                if (count < tmp2) {
                    backtracking[aa][bb] = new Point(aa + 1, bb, false);
                    count = tmp2;
                }
            }
        }
        if (count >= max) {
            max = count;
            startPoint = new Point(aa, bb, true);
        }
        return cache[aa][bb] = count;
    }


    static class Point {
        int a;
        int b;
        boolean check;

        public Point(int a, int b, boolean check) {
            this.a = a;
            this.b = b;
            this.check = check;
        }
    }
}


