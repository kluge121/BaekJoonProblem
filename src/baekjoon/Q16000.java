package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q16000 {

    static int row, column;
    static char[][] map;
    static int[][] imap;
    //전체 맵 스패닝트리 확인
    static boolean[][] visit;

    //스패닝 트리 만들기 위한 전역
    static int[] discover;
    static int dis_seq;

    //섬에 붙일 번호 인덱스
    static int isl_seq;


    static ArrayList<Integer> cycleList;
    static ArrayList<Point> nonCycleList;
    static boolean[] isCycle;
    static boolean[] isFinish;

    static int[] rowD = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] colD = {0, 1, 0, -1, -1, 1, 1, -1};

    static int start;
    static int end;

    //반복문안에서 해당 섬에 사이클 구간이 있는지 체크
    static boolean isFlag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        row = Integer.parseInt(a[0]);
        column = Integer.parseInt(a[1]);
        map = new char[row][column];
        imap = new int[row][column];
        cycleList = new ArrayList<>();
        nonCycleList = new ArrayList<>();
        isl_seq = 0;
        visit = new boolean[row][column];
        isFinish = new boolean[column * row];
        isCycle = new boolean[column * row];
        discover = new int[row * column];
        for (int i = 0; i < row; i++) {
            char[] b = br.readLine().toCharArray();
            for (int j = 0; j < column; j++) map[i][j] = b[j];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == '#' && !visit[i][j] && !isSige(i, j)) {
                    start = -1;
                    end = -1;
                    isl_seq++;
                    isFlag = false;

                    dis_seq = 1;
                    makeSpanningTree(i, j, -1);
                    if (isFlag) {
                        cycleList.add(isl_seq);
                    } else {
                        nonCycleList.add(new Point(i, j));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == '#' && imap[i][j] == 0) {
                    sb.append("X");
                } else if (map[i][j] == '#' && imap[i][j] > 0) {
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
//        System.out.println("사이클 " + cycleList.size() + "개");
//        System.out.println("논사이클 " + nonCycleList.size() + "개");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (isCycle[i * column + j]) {
                    System.out.print("# ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(imap[i][j]);
            }
            System.out.println();
        }
    }

    static boolean makeSpanningTree(int r, int c, int prev) {
        int nowNum = r * column + c;
        if (discover[nowNum] == 0) {
            imap[r][c] = isl_seq;
            discover[nowNum] = dis_seq++;
            visit[r][c] = true;
        }
        boolean flag = false;
        for (int i = 0; i < 8; i++) {

            int cr = r + rowD[i];
            int cc = c + colD[i];
            int next = cr * column + cc;

            if (isValid(cr, cc) && map[cr][cc] == '#') {
                if (!visit[cr][cc] && discover[next] == 0) {
                    if (makeSpanningTree(cr, cc, nowNum)) {
                        isCycle[nowNum] = true;
                        flag = true;
                    }
                } else if (!isFinish[next] && prev != next && discover[nowNum] > discover[next]) {
                    isCycle[nowNum] = true;
                    isCycle[next] = true;
                    start = next;
                    end = nowNum;
                    flag = true;
                    isFlag = true;
                }
            }
        }
        isFinish[nowNum] = true;
        return flag;
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < column;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isSige(int r, int c) {
        int aa = -1;
        int bb = -1;
        int cc = -1;
        int dd = -1;

        for (int i = r - 1; i >= 0; i--) {
            if (isCycle[i * column + c]) {
                aa = imap[i][c];
                break;
            }
        }

        for (int i = r + 1; i < row; i++) {
            if (isCycle[i * column + c]) {
                bb = imap[i][c];
                break;
            }
        }


        for (int i = c + 1; i < column; i++) {
            if (isCycle[r * column + i]) {
                cc = imap[r][i];
                break;
            }
        }

        for (int i = c - 1; i >= 0; i--) {
            if (isCycle[r * column + i]) {
                dd = imap[r][i];
                break;
            }
        }
        if (aa != -1 && aa == bb && bb == cc && cc == dd) {
            return true;
        }
        return false;
    }
}
