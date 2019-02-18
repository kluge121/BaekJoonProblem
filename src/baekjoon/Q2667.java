package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2667 {


    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> sortList = new ArrayList<>();
    static int count = 0;
    static int elementCount = 0;
    static int[] xDirection = {0, 1, 0, -1};
    static int[] yDirection = {1, 0, -1, 0};
    static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    elementCount = 1;
                    count++;
                    visit[i][j] = true;
                    dfs(i, j);
                    sortList.add(elementCount);
                }
            }
        }
        sortList.sort(Integer::compareTo);
        System.out.println(count);
        for(int i : sortList){
            System.out.println(i);
        }
    }
    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int cx = x + xDirection[i];
            int cy = y + yDirection[i];
            if (isValidPotion(cx, cy) && !visit[cx][cy] && map[cx][cy] == 1) {
                visit[cx][cy] = true;
                elementCount++;
                dfs(cx, cy);

            }
        }
    }

    static boolean isValidPotion(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}
