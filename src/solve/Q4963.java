package solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q4963 {


    static final int VISIT = 1;
    static final int NONE = 0;
    static final int ISLAND = 1;

    static int[][] visited = new int[51][51];
    static int mX;
    static int mY;
    static int[][] map;


    static ArrayList<TestCase> caseList = new ArrayList<TestCase>();
    final static int[] xPosition = {-1, 0, 1, -1, 1, -1, 0, 1};
    final static int[] yPosition = {1, 1, 1, 0, 0, -1, -1, -1};

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //문제입력
        while (true) {
            int tmpX = sc.nextInt();
            int tmpY = sc.nextInt();
            if (tmpX == 0 && tmpY == 0) break;
            int[][] tmpMap = new int[tmpX + 1][tmpY + 1];
            for (int j = 1; j <= tmpY; j++) {
                for (int i = 1; i <= tmpX; i++) {
                    tmpMap[i][j] = sc.nextInt();
                }
            }
            TestCase tmpCase = new TestCase();
            tmpCase.x = tmpX;
            tmpCase.y = tmpY;
            tmpCase.map = tmpMap;
            caseList.add(tmpCase);
        }

        //문제풀이
        for (TestCase testCase : caseList) {
            int count = 0;
            visitedInit();
            mX = testCase.x;
            mY = testCase.y;
            map = testCase.map;
            for (int j = 1; j <= testCase.y; j++) {
                for (int i = 1; i <= testCase.x; i++) {
                    if (visited[i][j] == NONE && map[i][j] == ISLAND) {
                        count++;
                        search(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void search(int x, int y) {
        if (visited[x][y] == VISIT) return;
        visited[x][y] = VISIT;
        for (int i = 0; i <= 7; i++) {
            int cX = x + xPosition[i];
            int cY = y + yPosition[i];
            if (isMove(cX, cY) && map[cX][cY] == ISLAND)
                search(cX, cY);
        }
    }

    static boolean isMove(int x, int y) {
        return (x >= 0 && y >= 0 && x <= mX && y <= mY);
    }

    static void visitedInit() {
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(visited[i], 0);
        }

    }

    static class TestCase {
        int x;
        int y;
        int[][] map;
    }


}
