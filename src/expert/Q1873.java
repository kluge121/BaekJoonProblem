package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1873 {

    static char[][] map;
    static int mRow;
    static int mColumn;
    static int cR = 0;
    static int cC = 0;
    static int direction = 0;
    static String[] out;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out = new String[T];

        for (int t = 0; t < T; t++) {
            String a[] = br.readLine().split(" ");
            mRow = Integer.parseInt(a[0]);
            mColumn = Integer.parseInt(a[1]);
            map = new char[mRow][mColumn];


            for (int i = 0; i < mRow; i++) {
                String b = br.readLine();
                for (int j = 0; j < mColumn; j++) {
                    char c = b.charAt(j);
                    map[i][j] = c;
                    if (c == '<' || c == '>' || c == '^' || c == 'v') {
                        cR = i;
                        cC = j;
                    }
                    if (c == '<') direction = 4;
                    else if (c == '^') direction = 1;
                    else if (c == '>') direction = 2;
                    else if (c == 'v') direction = 3;
                }
            }

            int N = Integer.parseInt(br.readLine());
            String c = br.readLine();
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) == 'S') {
                    shoot(cR, cC);
                } else if (c.charAt(i) == 'U') {
                    move(cR, cC, '^');
                } else if (c.charAt(i) == 'R') {
                    move(cR, cC, '>');
                } else if (c.charAt(i) == 'D') {
                    move(cR, cC, 'v');
                } else if (c.charAt(i) == 'L') {
                    move(cR, cC, '<');
                }
            }
            out[t] = String.format("#%d ", t + 1);
            for (int i = 0; i < mRow; i++) {
                for (int j = 0; j < mColumn; j++) {
                    out[t] += map[i][j];
                }
                if (i != mRow - 1)
                    out[t] += "\n";
            }
        }
        for (String a : out) {
            System.out.println(a);
        }

    }

    static void move(int cr, int cc, char m) {
        int tmpr = cr;
        int tmpc = cc;
        if (m == '^') {
            cr--;
            direction = 1;
        } else if (m == '>') {
            cc++;
            direction = 2;
        } else if (m == 'v') {
            cr++;
            direction = 3;
        } else if (m == '<') {
            cc--;
            direction = 4;
        }
        if (cr >= 0 && cr < mRow && cc >= 0 && cc < mColumn && map[cr][cc] == '.') {
            map[tmpr][tmpc] = '.';
            map[cr][cc] = m;
            cR = cr;
            cC = cc;
        } else {
            map[tmpr][tmpc] = m;
        }
    }

    static void shoot(int row, int column) {
        int cr = row;
        int cc = column;
        if (direction == 1) {
            cr--;
        } else if (direction == 2) {
            cc++;
        } else if (direction == 3) {
            cr++;
        } else if (direction == 4) {
            cc--;
        }
        while (true) {

            if (cr >= 0 && cr < mRow && cc >= 0 && cc < mColumn) {
                if (map[cr][cc] == '#') return;
                else if (map[cr][cc] == '*') {
                    map[cr][cc] = '.';
                    break;
                }

            } else {
                break;
            }
            if (direction == 1) {
                cr--;
            } else if (direction == 2) {
                cc++;
            } else if (direction == 3) {
                cr++;
            } else if (direction == 4) {
                cc--;
            }


        }


    }


}