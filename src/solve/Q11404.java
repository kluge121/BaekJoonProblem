package solve;

import java.util.Scanner;

public class Q11404 {

    public static void main(String args[]) {

        final int INF = 1000000000;
        int cityCount;
        int busCount;
        int[][] adj;

        Scanner sc = new Scanner(System.in);
        cityCount = sc.nextInt();
        busCount = sc.nextInt();
        adj = new int[cityCount + 1][cityCount + 1];

        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = INF;
            }
        }
        // 같은 간선 방향에 다른 비용이 있을 수 있기 때문에 최소값 체크
        for (int i = 0; i < busCount; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            if (adj[start][end] > value)
                adj[start][end] = value;
        }
        for (int k = 1; k <= cityCount; k++) {
            for (int i = 1; i <= cityCount; i++) {
                if (k == i) continue;
                for (int j = 1; j <= cityCount; j++) {
                    adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);

                }
            }
        }
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (adj[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int min(int a, int b){
        return a > b ? b : a;
    }
}