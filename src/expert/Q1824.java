package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1824 {

    static int UP = 0;
    static int RIGHT = 1;
    static int DOWN = 2;
    static int LEFT = 3;
    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};
    static int row;
    static int col;
    static boolean vis[][][][];
    static Queue<Point> q;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            boolean flag = true;
            q = new LinkedList<>();
            String[] a = br.readLine().split(" ");
            row = Integer.parseInt(a[0]);
            col = Integer.parseInt(a[1]);
            map = new char[row][col];
            vis = new boolean[row][col][4][16];
            for (int i = 0; i < row; i++) {
                String b = br.readLine();
                for (int j = 0; j < col; j++) {
                    map[i][j] = b.charAt(j);
                }
            }
            q.add(new Point(0, 0, RIGHT, 0));
            while (!q.isEmpty()) {
                Point p = q.poll();
                int dir = p.dir;
                int mem = p.mem;
                char op = map[p.r][p.c];
                if (op == '@') {
                    flag = false;
                    out[t] = String.format("#%d %s", t + 1, "YES");
                    break;
                }
                if (op != '?') {
                    if (op == '^') dir = UP;
                    else if (op == 'v') dir = DOWN;
                    else if (op == '<') dir = LEFT;
                    else if (op == '>') dir = RIGHT;
                    else if (op == '_') dir = (p.mem == 0) ? RIGHT : LEFT;
                    else if (op == '|') dir = (p.mem == 0) ? DOWN : UP;
                    else if (op >= 48 && op <= 57) mem = op - '0';
                    else if (op == '+') mem = (mem == 15) ? 0 : mem + 1;
                    else if (op == '-') mem = (mem == 0) ? 15 : mem - 1;
                    Point o = moving(p.r, p.c, dir, mem);
                    if (!vis[o.r][o.c][o.dir][mem]) {
                        vis[o.r][o.c][o.dir][mem] = true;
                        q.add(o);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        Point tmp = moving(p.r, p.c, i, mem);
                        if (!vis[tmp.r][tmp.c][tmp.dir][mem]) {
                            vis[tmp.r][tmp.c][tmp.dir][mem] = true;
                            q.add(tmp);
                        }
                    }
                }
            }
            if (flag) {
                out[t] = String.format("#%d %s", t + 1, "NO");
            }
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static class Point {
        int r, c, dir, mem;
        Point(int r, int c, int dir, int mem) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mem = mem;
        }
    }

    static Point moving(int r, int c, int dir, int mem) {
        int rr = r;
        int rc = c;
        rr = rr + rowD[dir];
        rc = rc + colD[dir];
        if (rr >= row) rr = 0;
        else if (rr < 0) rr = row - 1;
        else if (rc >= col) rc = 0;
        else if (rc < 0) rc = col - 1;
        return new Point(rr, rc, dir, mem);
    }


}
