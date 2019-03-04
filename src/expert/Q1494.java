package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q1494 {
    static ArrayList<Point> list;
    static boolean check[];
    static int N;
    static Long min = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            min = null;
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            check = new boolean[N];

            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                list.add(new Point(Integer.parseInt(a[0]), Integer.parseInt(a[1])));
            }
            search(0, 0);
            out[t] = String.format("#%d %d", t + 1, min);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void search(int index, int depth) {
        if(index == N) return;
        if (depth == N / 2) {
            long px = 0;
            long py = 0;
            long mx = 0;
            long my = 0;
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    px += list.get(i).x;
                    py += list.get(i).y;
                } else {
                    mx += list.get(i).x;
                    my += list.get(i).y;
                }
            }
            long rx = px - mx;
            long ry = py - my;

            if (min == null) {
                min = rx * rx + ry * ry;
            } else {
                min = Math.min(min, rx * rx + ry * ry);
            }
        }
        check[index] = true;
        search(index+1, depth + 1);
        check[index] = false;
        search(index+1, depth);

    }
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

}
