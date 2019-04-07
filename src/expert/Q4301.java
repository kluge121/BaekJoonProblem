package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4301 {

    static int row, col;
    static int[][] map;
    static int count;
    static int[] rowD = {-2, 0, 2, 0};
    static int[] colD = {0, 2, 0, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            col = Integer.parseInt(a[0]);
            row = Integer.parseInt(a[1]);
            map = new int[row][col];
            count = 1;
            map[0][0] = 1;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 0) {
                        boolean flag = true;
                        for (int k = 0; k < 4; k++) {
                            int cr = i + rowD[k];
                            int cc = j + colD[k];
                            if (isRange(cr, cc)) {
                                if (map[cr][cc] == 1) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            map[i][j] = 1;
                            count++;
                        }
                    }
                }
            }
            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
}
