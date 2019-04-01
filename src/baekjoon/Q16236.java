package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q16236 {
    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};


    static int[][] map;
    static Point sharkP;
    static int size = 2;
    static int exp = 2;
    static int count = 0;
    static PriorityQueue<Point> pq;
    static Queue<Point> q;
    static int N;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(tmp[j]);
                if (value == 9)
                    sharkP = new Point(i, j, 0);
                map[i][j] = value;
            }
        }

        while (true) {
            q = new LinkedList<>();
            q.add(sharkP);
            visit = new boolean[N][N];
            pq = new PriorityQueue<>();
            visit[sharkP.r][sharkP.c] = true;
            map[sharkP.r][sharkP.c] = 0;
            int eat = find();
            if (eat < 1) break;
            Point yummy = pq.poll();

            count += yummy.level;
            sharkP = new Point(yummy.r, yummy.c, 0);
            map[yummy.r][yummy.c] = 0;
            exp--;
            if (exp == 0) {
                size++;
                exp = size;
            }
        }

        System.out.println(count);

    }


    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static class Point implements Comparable<Point> {
        int r, c, level;

        public Point(int r, int c, int level) {
            this.r = r;
            this.c = c;
            this.level = level;
        }

        @Override
        public int compareTo(Point o) {
            if (level > o.level) {
                return 1;
            } else if (level < o.level) {
                return -1;
            } else {
                if (r > o.r) return 1;
                else if (r < o.r) return -1;
                else {
                    if (c > o.c) return 1;
                    else return -1;
                }
            }
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", level=" + level +
                    '}';
        }
    }

    static int find() {
        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int cr = p.r + rowD[i];
                int cc = p.c + colD[i];
                if (isRange(cr, cc) && !visit[cr][cc]) {
                    visit[cr][cc] = true;
                    if (map[cr][cc] == 0 || map[cr][cc] == size) {
                        q.add(new Point(cr, cc, p.level + 1));
                    } else if (map[cr][cc] < 9 && map[cr][cc] < size) {
                        pq.add(new Point(cr, cc, p.level + 1));
                        count++;
                    }
                }
            }
        }

        return count;
    }


}
