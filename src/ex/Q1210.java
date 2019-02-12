package ex;

import java.util.Scanner;

public class Q1210 {
    static int[][] map;
    static int row_goal;
    static int column_goal;
    static String[] out;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        out = new String[10];
        for (int t = 1; t <= 10; t++) {
            sc.nextInt();
            map = new int[100][100];

            for (int row = 0; row < 100; row++) {
                for (int column = 0; column < 100; column++) {
                    int value = sc.nextInt();
                    map[row][column] = value;
                    if (value == 2) {
                        row_goal = row;
                        column_goal = column;
                    }
                }
            }
            row_goal--;
            boolean sideFlag = false;
            while (row_goal != 0) {
                if (!sideFlag && isValidRange(row_goal, column_goal - 1) && map[row_goal][column_goal - 1] == 1) {
                    while (isValidRange(row_goal, column_goal - 1) && map[row_goal][column_goal - 1] == 1) {
                        column_goal--;
                    }
                    sideFlag = true;
                }
                else if (!sideFlag && isValidRange(row_goal, column_goal + 1) && map[row_goal][column_goal + 1] == 1) {
                    while (isValidRange(row_goal, column_goal + 1) && map[row_goal][column_goal + 1] == 1) {
                        column_goal++;
                    }
                    sideFlag = true;
                }
                else {
                    row_goal--;
                    sideFlag = false;
                }
            }
            out[t-1] = String.format("#%d %d",t,column_goal);
        }
        for(String a : out){
            System.out.println(a);
        }
    }

    static boolean isValidRange(int row, int column) {
        return row >= 0 && row < 100 && column >= 0 && column < 100;
    }
}
