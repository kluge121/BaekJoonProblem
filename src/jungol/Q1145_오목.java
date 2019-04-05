package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1145_오목 {

    static final int BLACK = 1;
    static final int WHITE = 2;

    static int[][] map;

    static int[] rowD = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] colD = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int nowRow;
    static int nowCol;
    static int nowType;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[19][19];


        for (int i = 0; i < N; i++) {


            String[] a = br.readLine().split(" ");
            nowCol = Integer.parseInt(a[0]);
            nowRow = Integer.parseInt(a[1]);
            if (nowCol < 0 || nowRow < 0 || nowCol >= 19 || nowRow >= 19) {
                N++;
                continue;
            }
            map[nowRow][nowCol] = i % 2 == 0 ? BLACK : WHITE;
            nowType = map[nowRow][nowCol];


            int dae1 = check(nowRow, nowCol, 0, 0) + check(nowRow, nowCol, 4, 0) + 1;
            int dae2 = check(nowRow, nowCol, 2, 0) + check(nowRow, nowCol, 6, 0) + 1;
            int updown = check(nowRow, nowCol, 1, 0) + check(nowRow, nowCol, 5, 0) + 1;
            int rl = check(nowRow, nowCol, 7, 0) + check(nowRow, nowCol, 3, 0) + 1;

            if (dae1 == 5 || dae2 == 5 || updown == 5 || rl == 5) {
                if (nowType == BLACK) System.out.println("Black win");
                else System.out.println("White win");
                return;
            }


        }
        System.out.println("Save");
    }

    static int check(int row, int col, int dir, int d) {
        int cr = row + rowD[dir];
        int cc = col + colD[dir];
        if (isRange(cr, cc)) return check(cr, cc, dir, d + 1);
        else return d;

    }

    static boolean isRange(int row, int column) {
        return row >= 0 && column >= 0 && row < 19 && column < 19 && map[row][column] == nowType;
    }


}

