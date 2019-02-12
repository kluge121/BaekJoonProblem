package baekjoon;

import java.util.Scanner;

public class Q2468 {

    static final int VISIT = 1;
    static int size = 0;
    static int[][] adj;
    static int[][] visited;
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static int maxHeight = 0;
    static int minHeight = 101;
    //비가 안오거나 지형 중 최소 높이보다 적게 비가오면 안전지대는 1!
    static int maxSafeArea = 1;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        adj = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int tmp = sc.nextInt();
                //입력 과정중 최소 높이와 최대 높이 확인
                if (tmp > maxHeight) maxHeight = tmp;
                if (tmp < minHeight) minHeight = tmp;
                adj[j][i] = tmp;
            }
        }
        for (int level = minHeight; level <= maxHeight; level++) {
            int nowSafeAreaCount = 0;
            visited = new int[size+1][size+1];
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    if (adj[j][i]>=level && isNotVisit(j,i)){
                        nowSafeAreaCount++;
                        dfs(j,i,level);
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea,nowSafeAreaCount);
        }
        System.out.println(maxSafeArea);
    }
    static void dfs(int x, int y, int level) {
        visited[x][y] = VISIT;
        for (int i = 0; i <= 3; i++) {
            int cX = x + xDirection[i];
            int cY = y + yDirection[i];
            if (isMoveRange(cX, cY) && isNotVisit(cX, cY) && adj[cX][cY] >= level) {
                dfs(cX, cY, level);
            }
        }
    }
    static boolean isMoveRange(int x, int y) {
        return (x <= size && y <= size && x >= 1 && y >= 1);
    }

    static boolean isNotVisit(int x, int y) {
        return visited[x][y] != VISIT;
    }


}
