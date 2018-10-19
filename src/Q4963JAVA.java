import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4963JAVA {

    private final static int VISIT = 1;
    private final static int NONE = 0;
    private final static int ISLAND = 1;

    private static int[][] cache = new int[51][51];
    private static int mX = 0;
    private static int mY = 0;
    static int[][] mMap;

    public static void main(String args[]) {

        ArrayList<Case> caseList = new ArrayList<Case>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            Case tmpCase = new Case();
            tmpCase.x = sc.nextInt();
            tmpCase.y = sc.nextInt();
            tmpCase.map = new int[tmpCase.x + 1][tmpCase.y + 1];

            if (tmpCase.x == 0 && tmpCase.y == 0)
                break;

            for (int i = 1; i <= tmpCase.y; i++) {
                for (int j = 1; j <= tmpCase.x; j++) {
                    tmpCase.map[j][i] = sc.nextInt();
                }
            }
            caseList.add(tmpCase);
        }


        for (Case c : caseList) {
            int count = 0;
            mX = c.x;
            mY = c.y;
            mMap = c.map;
            for (int i = 1; i <= mX; i++) {
                for (int j = 1; j <= mY; j++) {
                    if (cache[i][j] == NONE && c.map[i][j] == ISLAND) {
                        search(i, j);
                        count++;
                    }
                }
            }
            mMapInit();
            System.out.println(count);
        }

    }

    private static void search(int x, int y) {
        if (cache[x][y] == VISIT) return;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (isMove(x + i, y + j) && mMap[x + i][y + j] == ISLAND) {
                    cache[x + i][y + j] = VISIT;
                    search(x + i, y + j);
                }
            }
        }
    }

    private static void mMapInit() {
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(cache[i], NONE);
        }
    }

    private static Boolean isMove(int x, int y) {
        return (x <= mX && y <= mY);
    }


    static class Case {
        int[][] map;
        int x;
        int y;
    }
}
