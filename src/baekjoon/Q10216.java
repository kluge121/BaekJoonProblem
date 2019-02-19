package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q10216 {

    static boolean[][] adj;
    static boolean[] visit;
    static ArrayList<Point> pointList;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            count = 0;
            int N = Integer.parseInt(br.readLine());
            adj = new boolean[N + 1][N + 1];
            visit = new boolean[N + 1];
            pointList = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                String a[] = br.readLine().split(" ");
                int x = Integer.parseInt(a[0]);
                int y = Integer.parseInt(a[1]);
                int r = Integer.parseInt(a[2]);
                pointList.add(new Point(x, y, r));
            }

            //간선연결정보 세팅
            for (int i = 0; i < pointList.size(); i++) {
                for (int j = 0; j < pointList.size(); j++) {
                    if (i != j && (pointList.get(i).r + pointList.get(j).r) >= getDistance(pointList.get(i), pointList.get(j))) {
                        adj[i][j] = true;
                        adj[j][i] = true;
                    }
                }
            }
            visit = new boolean[N + 1];
            for (int i = 0; i < pointList.size(); i++) {
                if (!visit[i]) {
                    count++;
                    visit[i] = true;
                    search(i);
                }
            }
            System.out.println(count);
        }
    }

    static void search(int index) {
        for (int i = 0; i < pointList.size(); i++) {
            if (!visit[i] && adj[index][i]) {
                visit[i] = true;
                search(i);
            }

        }
    }

    static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static class Point {
        int x, y, r;

        public Point(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }


}
