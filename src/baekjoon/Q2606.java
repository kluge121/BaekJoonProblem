package baekjoon;

import java.util.Scanner;

public class Q2606 {

    static int[] visited;
    static int[][] adj;
    static int[] output;
    static int outCount = 0;
    static int POSSIBLE = 1;
    static int computerCount;
    static int pair;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        computerCount = sc.nextInt();
        pair = sc.nextInt();
        adj = new int[computerCount + 1][computerCount + 1];
        visited = new int[computerCount + 1];
        output = new int[computerCount + 1];

        for (int i = 0; i < pair; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            adj[tmp1][tmp2] = POSSIBLE;
            adj[tmp2][tmp1] = POSSIBLE;
        }
        //1이 포함되는 컴포넌트를 찾는다 - 재귀시작
        search(1);

        for (int i = 2; i <= computerCount; i++) {
            if (output[i] == POSSIBLE) outCount++;
        }
        System.out.print(outCount);
    }

    static void search(int i) {
        //메모이제이션 체크
        if (visited[i] == 1) return;
        visited[i] = 1;
        for (int j = 1; j <= computerCount; j++) {
            if (adj[i][j] == POSSIBLE) {
                output[j] = 1;
                search(j);
            }
        }
    }
}

