package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q7250 {

    static final int N_ANT = 1;
    static final int C_ANT = 2;
    static final int BIL = 3;
    static final int FIRE = 4;

    static char[][] map;
    static char[][] map2;
    static int row;
    static int column;
    static int k;
    static Point ant;
    static Point bil;
    static Point end;
    static ArrayList<Point> fireList;
    static ArrayList<Point> fireList2;
    static Queue<Point> queue;

    static int ac;
    static int bc;
    static int[] rDir = {-1, 0, 1, 0};
    static int[] cDir = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");
            row = Integer.parseInt(a[0]);
            column = Integer.parseInt(a[1]);
            k = Integer.parseInt(a[2]);
            fireList = new ArrayList<>();
            fireList2 = new ArrayList<>();
            queue = new LinkedList<>();
            map = new char[row][column];
            map2 = new char[row][column];

            ant = null;
            bil = null;
            end = null;
            ac = -1;
            bc = -1;

            for (int i = 0; i < row; i++) {
                String b = br.readLine();
                for (int j = 0; j < column; j++) {
                    char tmp = b.charAt(j);
                    map[i][j] = tmp;
                    map2[i][j] = tmp;
                    if (tmp == 'S') {
                        ant = new Point(i, j, 0, -1, N_ANT);
                    } else if (tmp == 'V') {
                        bil = new Point(i, j, 0, -2, BIL);
                    } else if (tmp == 'E') {
                        end = new Point(i, j, 0, -2, -1);
                    } else if (tmp == 'F') {
                        fireList.add(new Point(i, j, 0, -2, FIRE));
                        fireList2.add(new Point(i, j, 0, -2, FIRE));
                    }
                }
            }


            if (ant == null || end == null) {
                out[t] = String.format("#%d %d", t + 1, -1);
                continue;
            }
            queue.add(ant);

            int pre = 0;

            while (!queue.isEmpty()) {

                Point tp = queue.poll();

                for(int i = 0 ; i<row; i++){
                    for(int j = 0 ; j<column; j++){
                        System.out.print(map[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println("----------------------");

                if (tp.column == end.column && tp.row == end.row) {
                    ac = tp.level;
                    break;
                }

                if (tp.kLevel == -2) {
                    tp.kLevel = -1;
                }

                if (tp.kLevel == 0) {
                    tp.state = N_ANT;
                    tp.kLevel = -2;
                }

                ArrayList<Point> tmpList = new ArrayList<>();


                if (pre != tp.level) {
                    pre = tp.level;
                    for (Point p : fireList) {
                        for (int i = 0; i < 4; i++) {
                            int cr = p.row + rDir[i];
                            int cc = p.column + cDir[i];
                            if (cr >= 0 && cr < row && cc >= 0 && cc < column && map[cr][cc]!='F') {
                                int result = validCheck(cc, cr, FIRE, map);
                                if (result == 1) {
                                    map[cr][cc] = 'F';
                                    tmpList.add(new Point(cr, cc, 0, -2, FIRE));
                                }

                            }

                        }
                    }

                    fireList.addAll(tmpList);
                }


                for (int i = 0; i < 4; i++) {

                    int cr = tp.row + rDir[i];
                    int cc = tp.column + cDir[i];

                    if (cr >= 0 && cr < row && cc >= 0 && cc < column) {
                        if (tp.state == N_ANT) {

                            //일반 상태에서 갈 수 있을 떄
                            if (validCheck(cr, cc, N_ANT, map) == 1) {
                                queue.add(new Point(cr, cc, tp.level + 1, -1, N_ANT));
                            }
                            //일반 상태에서 벽을 만나서 변신해서 통과 할 때
                            if (validCheck(cr, cc, N_ANT, map) == -1 && tp.kLevel == -1) {
                                queue.add(new Point(cr, cc, tp.level + 1, k, C_ANT));
                            }
                        } else if (tp.state == C_ANT) {
                            //변신 상태에서 움직일 때
                            if (validCheck(cr, cc, C_ANT, map) == 1) {
                                int tmpKLevel = 0;
                                if (map[cr][cc] == 'A') {
                                    tmpKLevel = k;
                                } else {
                                    tmpKLevel = tp.kLevel - 1;
                                }
                                queue.add(new Point(cr, cc, tp.level + 1, tmpKLevel, C_ANT));
                            }
                        }
                    }
                }
            }






            if (bil == null) {
                out[t] = String.format("#%d %d", t + 1, ac);
                continue;
            }
            if (ac == -1) {
                out[t] = String.format("#%d %d", t + 1, -1);
                continue;
            }


            queue = new LinkedList<>();
            queue.add(bil);
            boolean[][] visit = new boolean[row][column];
            while (!queue.isEmpty()) {
                Point tp = queue.poll();

                if (tp.column == end.column && tp.row == end.row) {
                    bc = tp.level;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int cr = tp.row + rDir[i];
                    int cc = tp.column + cDir[i];
                    if (cr >= 0 && cr < row && cc >= 0 && cc < column) {
                        if (validCheck(cr, cc, BIL, map2) == 1 && !visit[cr][cc]) {
                            visit[cr][cc] = true;
                            queue.add(new Point(cr, cc, tp.level + 1, 0, 0));
                        }
                    }
                }
            }



            if (bc == -1) {
                out[t] = String.format("#%d %d", t + 1, ac);
            } else if (ac < bc) {
                out[t] = String.format("#%d %d", t + 1, ac);
            } else {
                out[t] = String.format("#%d %d", t + 1, -1);
            }

        }

        for (String a : out) {
            System.out.println(a);
        }

    }


    static int validCheck(int r, int c, int type, char[][] map) {

        if (type == N_ANT) {
            if (map[r][c] == 'A' || map[r][c] == 'V' || map[r][c] == 'E') return 1;
            else return -1;
        }
        if (type == C_ANT) {
            if (map[r][c] == 'A' || map[r][c] == 'V' || map[r][c] == 'W' || map[r][c] == 'E') return 1;
            else return -1;
        }
        if (type == BIL) {
            if (map[r][c] == 'A' || map[r][c] == 'F' || map[r][c] == 'E') return 1;
            else return -1;
        }
        if (type == FIRE) {
            if (map[r][c] != 'W' && map[r][c] != 'X' && map[r][c]!='E') return 1;
            else return -1;
        }
        return -1;
    }

    static class Point {
        int row, column, level, kLevel, state;

        public Point(int row, int column, int level, int kLevel, int state) {
            this.row = row;
            this.column = column;
            this.level = level;
            this.kLevel = kLevel;
            this.state = state;
        }
    }


}
