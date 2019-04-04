package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1145_오목 {

    static final int BLACK = 1;
    static final int WHITE = 2;
    static final int NONE = 0;
    static int[][] map;

    static int[] rowD = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] colD = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[19][19];
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int col = Integer.parseInt(a[0]);
            int row = Integer.parseInt(a[1]);
            if (col < 0 || row < 0 || col >= 19 || row >= 19) {
                N++;
                continue;
            }
            if (i % 2 == 0) map[row][col] = BLACK;
            else map[row][col] = WHITE;


            //대각선
            int dae1 = check(row, col, 0, map[row][col], 0) + check(row, col, 4, map[row][col], 0) + 1;
            int dae2 = check(row, col, 2, map[row][col], 0) + check(row, col, 6, map[row][col], 0) + 1;
            int updw = check(row, col, 1, map[row][col], 0) + check(row, col, 5, map[row][col], 0) + 1;
            int rl = check(row, col, 7, map[row][col], 0) + check(row, col, 3, map[row][col], 0) + 1;

            if (dae1 == 5 || dae2 == 5 || updw == 5 || rl == 5) {
                if (map[row][col] == BLACK) System.out.println("Black win");
                else System.out.println("White win");
                return;
            }


        }

        System.out.println("Save");


    }

    static int check(int row, int col, int dir, int type, int d) {
        int cr = row + rowD[dir];
        int cc = col + colD[dir];

        if (isRange(cr, cc, type)) return check(cr, cc, dir, type, d + 1);
        else return d;

    }

    static boolean isRange(int row, int column, int type) {
        return row >= 0 && column >= 0 && row < 19 && column < 19 && map[row][column] == type;
    }


}

