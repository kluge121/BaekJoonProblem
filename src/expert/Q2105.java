package expert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2105 {
    static int N;
    static int max;
    static int[][] map;
    static boolean[][] visit;
    static boolean[] eatCheck;
    static Point starPoint;
    static int[] rowD = {-1, -1, 1, 1};
    static int[] colD = {-1, 1, 1, -1};
    static int[] possible = {1, 2, 3, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = -1;
            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(a[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        visit = new boolean[N][N];
                        eatCheck = new boolean[101];
                        starPoint = new Point(i, j, map[i][j]);
                        search(starPoint, 1, k, 3);
                    }
                }
            }
            out[t] = String.format("#%d %d", t + 1, max);
        }
        for (String a : out)
            System.out.println(a);
    }

    static void search(Point p, int depth, int dir, int count) {

        if (p.row == starPoint.row && p.column == starPoint.column && depth != 1) {
            max = Math.max(max, depth - 1);
            return;
        }

        int cr = p.row + rowD[dir];
        int cc = p.column + colD[dir];

        if (isValid(cr, cc) && !eatCheck[map[cr][cc]] && !visit[cr][cc]) {
            Point tmp = new Point(cr, cc, map[cr][cc]);
            eatCheck[tmp.value] = true;
            visit[cr][cc] = true;
            search(tmp, depth + 1, dir, count);
            eatCheck[tmp.value] = false;
            visit[cr][cc] = false;
        }

        if (count > 0) {
            cr = p.row + rowD[possible[dir]];
            cc = p.column + colD[possible[dir]];
            if (isValid(cr, cc) && !eatCheck[map[cr][cc]] && !visit[cr][cc]) {
                Point tmp2 = new Point(cr, cc, map[cr][cc]);
                eatCheck[tmp2.value] = true;
                visit[cr][cc] = true;
                search(tmp2, depth + 1, possible[dir], count - 1);
                eatCheck[tmp2.value] = false;
                visit[cr][cc] = false;
            }
        }
    }
    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static class Point {
        int row, column, value;

        public Point(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
