package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5644_solving {

    static int[] xD = {0, 0, 1, 0, -1};
    static int[] yD = {0, -1, 0, 1, 0};
    static int M; //시간
    static int BC; // 충전소 개수

    static Point[][] map;

    static Queue<Integer> aMoveList;
    static Queue<Integer> bMoveList;

    static int sum;

    static Point A;
    static Point B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");
            M = Integer.parseInt(a[0]);
            BC = Integer.parseInt(a[1]);
            map = new Point[11][11];
            aMoveList = new LinkedList<>();
            bMoveList = new LinkedList<>();

            sum = 0;
            String[] b = br.readLine().split(" ");
            String[] c = br.readLine().split(" ");
            A = new Point(1, 1, 0);
            B = new Point(10, 10, 0);

            //사용자 이동 리스트 생성
            aMoveList.offer(0);
            bMoveList.offer(0);
            for (int i = 0; i < b.length; i++) {
                aMoveList.offer(Integer.parseInt(b[i]));
                bMoveList.offer(Integer.parseInt(c[i]));
            }

            int bcCount = 1;
            //배터리 충전소 마킹
            for (int i = 0; i < BC; i++) {
                boolean[][] visit = new boolean[11][11];
                Queue<Point> q = new LinkedList<>();
                String[] d = br.readLine().split(" ");
                int x = Integer.parseInt(d[0]);
                int y = Integer.parseInt(d[1]);
                int range = Integer.parseInt(d[2]);
                int process = Integer.parseInt(d[3]);
                visit[y][x] = true;
                q.offer(new Point(x, y, 0));
                while (!q.isEmpty()) {
                    Point p = q.poll();
                    processAdd(p.x, p.y, process, bcCount);
                    if (p.level == range) continue;
                    for (int j = 1; j <= 4; j++) {
                        int cx = p.x + xD[j];
                        int cy = p.y + yD[j];
                        if (isRange(cx, cy)) {
                            visit[cy][cx] = true;
                            q.offer(new Point(cx, cy, p.level + 1));
                        }
                    }
                }
                bcCount++;
            }


            while (!aMoveList.isEmpty()) {
                ArrayList<Point> aList = null;
                ArrayList<Point> bList = null;

                int sv = 0;

                if (map[A.y][A.x] != null) {
                    aList = map[A.y][A.x].powerList;
                    Collections.sort(aList);
                }
                if (map[B.y][B.x] != null) {
                    bList = map[B.y][B.x].powerList;
                    Collections.sort(bList);
                }

                if (aList != null && bList != null) {
                    for (Point point : aList) {
                        for (Point point1 : bList) {
                            if (point.bc == point1.bc) {
                                sv = Math.max(sv, point.process);
                            } else {
                                sv = Math.max(sv, point.process + point1.process);
                            }
                        }
                    }
                } else if (aList == null && bList != null) {
                    sv =bList.get(0).process;

                } else if (aList != null) {
                    sv = aList.get(0).process;
                }

                int ta = aMoveList.poll();
                int tb = bMoveList.poll();

                A.x += xD[ta];
                A.y += yD[ta];
                B.x += xD[tb];
                B.y += yD[tb];

                sum += sv;

            }

            out[t] = String.format("#%d %d", t + 1, sum);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static void processAdd(int x, int y, int process, int bc) {
        if (map[y][x] == null) {
            map[y][x] = new Point(new ArrayList<>());
        }
        map[y][x].powerList.add(new Point(process, bc));
        Collections.sort(map[y][x].powerList);

    }

    static boolean isRange(int x, int y) {
        return x >= 1 && y >= 1 && x <= 10 && y <= 10;
    }

    static class Point implements Comparable<Point> {
        int x, y, level, process, bc;
        ArrayList<Point> powerList;

        public Point(ArrayList<Point> powerList) {
            this.powerList = powerList;
        }

        public Point(int process, int bc) {
            this.process = process;
            this.bc = bc;
        }

        public Point(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        @Override
        public int compareTo(Point o) {
            if (process < o.process) return 1;
            return -1;
        }
    }
}
