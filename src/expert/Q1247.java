package expert;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1247 {

    static ArrayList<Point> list;
    static Point company;
    static Point home;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            list = new ArrayList<>();
            n = sc.nextInt();
            company = new Point(sc.nextInt(), sc.nextInt());
            home = new Point(sc.nextInt(), sc.nextInt());
            for (int i = 0; i < n; i++) {
                list.add(new Point(sc.nextInt(), sc.nextInt()));
            }
            int min = 999999999;

            for (int i = 0; i < list.size(); i++) {
                visited = new boolean[n];
                min = Math.min(min, search(1, i, i) + getDistance(company, list.get(i)));
            }
            out[t] = String.format("#%d %d", t + 1, min);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static int search(int depth, int currentIndex, int preIndex) {
        if (depth == n) {
            return getDistance(list.get(currentIndex), list.get(preIndex)) + getDistance(list.get(currentIndex), home);
        }
        visited[currentIndex] = true;
        int min = 99999999;
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                min = Math.min(min, search(depth + 1, i, currentIndex) + getDistance(list.get(currentIndex), list.get(preIndex)));
                visited[i] = false;
            }
        }
        return min;
    }


    static int getDistance(Point a, Point b) {
        int distance = 0;
        distance = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        return distance;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
