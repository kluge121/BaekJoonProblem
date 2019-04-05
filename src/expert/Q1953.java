package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1953 {


    static int row, col, l;
    static boolean[][] visit;
    static boolean[][] checkSum;
    static int[][] map;
    static int count;
    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            row = Integer.parseInt(a[0]);
            col = Integer.parseInt(a[1]);
            map = new int[row][col];
            checkSum = new boolean[row][col];
            int startRow = Integer.parseInt(a[2]);
            int startCol = Integer.parseInt(a[3]);
            l = Integer.parseInt(a[4]);
            visit = new boolean[row][col];
            count = 0;
            for (int i = 0; i < row; i++) {
                String[] c = br.readLine().split(" ");
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(c[j]);
                }
            }
            visit[startRow][startCol] =true;
            dfs(startRow, startCol, 1);


            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static void dfs(int r, int c, int d) {
        if(!checkSum[r][c]){
            checkSum[r][c]= true;
            count++;
        }
        if (d == l) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cr = r + rowD[i];
            int cc = c + colD[i];
            if (isRange(cr, cc) && !visit[cr][cc]&&isConnect(map[r][c], map[cr][cc], i)) {
                visit[cr][cc]= true;
                dfs(cr, cc, d + 1);
                visit[cr][cc]= false;
            }
        }
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }

    static boolean isConnect(int oType, int nType, int dir) {
        if (nType == 0) return false;
        if (dir == 0) {
            if ((oType == 1 || oType == 2 || oType == 4 || oType == 7) && (nType == 1 || nType == 2 || nType == 5 || nType == 6))
                return true;
        }
        if (dir == 2) {
            if ((oType == 1 || oType == 2 || oType == 5 || oType == 6) && (nType == 1 || nType == 2 || nType == 4 || nType == 7))
                return true;
        }
        if (dir == 1) {
            if ((oType == 1 || oType == 3 || oType == 4 || oType == 5) && (nType == 1 || nType == 3 || nType == 6 || nType == 7)) {
                return true;
            }
        }
        if (dir == 3) {
            if ((oType == 1 || oType == 3 || oType == 6 || oType == 7) && (nType == 1 || nType == 3 || nType == 4 || nType == 5)) {
                return true;
            }
        }
        return false;
    }
}
