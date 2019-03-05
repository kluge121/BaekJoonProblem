package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1861 {


    static int N;
    static int[][] map;
    static Queue<Point> queue;
    static int[] rd = {-1, 0, 1, 0};
    static int[] cd = {0, 1, 0, -1};
    static int max = -1;
    static int startNum;

    static ArrayList<Integer> startList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {
            max = -1;
            N = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            map = new int[N][N];
            startList = new ArrayList<>();


            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(a[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    queue = new LinkedList<>();
                    queue.add(new Point(i, j, 1));
                    startNum = map[i][j];
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();

                        if (p.level > max) {
                            startList = new ArrayList<>();
                            startList.add(startNum);
                            max = p.level;
                        } else if (p.level == max) {
                            startList.add(startNum);
                        }

                        for (int k = 0; k < 4; k++) {
                            int cr = p.row + rd[k];
                            int cc = p.column + cd[k];
                            if (isValid(cr, cc, map[p.row][p.column])) {
                                queue.add(new Point(cr, cc, p.level + 1));
                            }
                        }

                    }

                }
            }

            startList.sort(Integer::compareTo);
            out[t] = String.format("#%d %d %d",t+1,startList.get(0),max);
        }

        for(String a : out){
            System.out.println(a);
        }

    }


    static boolean isValid(int row, int column, int nowValue) {
        return row >= 0 && row < N && column >= 0 && column < N && nowValue + 1 == map[row][column];

    }

    static class Point {
        int row, column, level;

        public Point(int row, int column, int level) {
            this.row = row;
            this.column = column;
            this.level = level;
        }
    }
}
