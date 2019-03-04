package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1258 {

    static int[][] map;
    static int N;
    static int tmpRow;
    static int tmpColumn;
    static boolean visit[][];
    static ArrayList<Matrix> matrices;
    static int subCount;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            subCount = 0;
            matrices = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(a[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0 && !visit[i][j]) {
                        subCount++;
                        search(i, j, 1, 0);
                        search(i, j, 2, 0);
                        matrices.add(new Matrix(tmpRow+1, tmpColumn+1));
                        for (int r = i; r <= tmpRow + i; r++) {
                            for (int c = j; c <= tmpColumn + j; c++) {
                                visit[r][c] = true;
                            }
                        }
                    }
                }
            }

            matrices.sort(Matrix::compareTo);
            StringBuilder a = new StringBuilder(String.format("#%d %d ", t + 1, subCount));
            for (Matrix m : matrices) {
                a.append(m.row ).append(" ").append(m.column ).append(" ");
            }
            out[t] = a.toString();
        }
        for (String a : out) {
            System.out.println(a);
        }
    }




    static void search(int row, int column, int type, int count) {
        if (type == 1) {
            if (isValidMove(row + 1, column)) {
                search(row + 1, column, 1, count + 1);
            } else
                tmpRow = count;
        } else if (type == 2) {
            if (isValidMove(row, column + 1))
                search(row, column + 1, 2, count + 1);
            else
                tmpColumn = count;
        }
    }

    static class Matrix implements Comparable<Matrix> {
        int row;
        int column;
        public Matrix(int row, int column) {
            this.row = row;
            this.column = column;
        }
        @Override
        public int compareTo(Matrix o) {
            if (row * column > o.row * o.column)
                return 1;
            else if (row * column < o.row * o.column) {
                return -1;
            } else {
                if (row > o.row) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    static boolean isValidMove(int row, int column) {
        return (row >= 0 && row < N && column >= 0 && column < N) && map[row][column] != 0;
    }
}
