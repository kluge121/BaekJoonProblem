package baekjoon;

import java.util.Scanner;

public class Q10219 {
    static int[][] map;
    static int row;
    static int column;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            row = sc.nextInt();
            column = sc.nextInt();
            sc.nextLine();
            map = new int[row][column];
            for (int i = 0; i < row; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < column; j++) {
                    char input = line.charAt(j);
                    map[i][j] = input;
                }
            }
            reverse();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print((char) map[i][j]);
                }
                System.out.println();
            }
        }
    }

    static void reverse() {
        int[][] tmpMap = new int[row][column];
        int n = column - 1;
        for (int i = 0; i < row; i++) {
            n = column - 1;
            for (int j = 0; j < column; j++) {
                tmpMap[i][j] = map[i][n--];
            }
        }
        map = tmpMap;
    }


}
