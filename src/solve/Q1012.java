package solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1012 {

    static final int NONE = 0;
    static final int VISIT = 1;

    static int[][] visited = new int[51][51];

    static int[] xPosition = {1, -1, 0, 0};
    static int[] yPosition = {0, 0, 1, -1};

    static ArrayList<TestCase> caseList = new ArrayList<TestCase>();
    static int mX = 0;
    static int mY = 0;
    static int[][] mMap;

    public static void main(String args[]) {

        int testCaseCount = 0;
        Scanner sc = new Scanner(System.in);
        testCaseCount = sc.nextInt();


        for (int i = 0; i < testCaseCount; i++) {
            TestCase tmp = new TestCase();
            tmp.x = sc.nextInt();
            tmp.y = sc.nextInt();
            int vCount = sc.nextInt();
            tmp.map = new int[tmp.x + 1][tmp.y + 1];
            for (int j = 0; j < vCount; j++) {
                tmp.map[sc.nextInt()][sc.nextInt()] = 1;
            }
            caseList.add(tmp);
        }
        for (TestCase item : caseList) {
            mX = item.x;
            mY = item.y;
            mMap = item.map;
            int count = 0;
            for (int i = 0; i <= mX; i++) {
                for (int j = 0; j <= mY; j++) {

                    if (visited[i][j] == NONE && mMap[i][j] == 1) {
                        search(i, j);
                        count++;
                    }
                }
            }
            mapInit();
            System.out.println(count);
        }
    }
    static void search(int x, int y) {

        if (visited[x][y] == VISIT) return;

        for (int i = 0; i <= 3; i++) {

            int cX = x + xPosition[i];
            int cY = y + yPosition[i];

            if (isMove(cX, cY) && mMap[cX][cY] == 1) {
                visited[x][y] = VISIT;
                search(cX, cY);
            }
        }

    }
    static boolean isMove(int x, int y) {
        return (x >= 0 && y >= 0 && x <= mX && y <= mY);
    }

    static void mapInit() {
        for (int i = 0; i <= 50; i++) {
            Arrays.fill(visited[i], 0);

        }
    }

    static class TestCase {
        int x;
        int y;
        int map[][];

    }
}
