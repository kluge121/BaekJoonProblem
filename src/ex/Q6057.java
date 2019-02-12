package ex;

import java.util.Scanner;

public class Q6057 {

    static int map[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int count = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                map[a - 1][b - 1] = 1;
            }
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    if (map[i][j] != 1) continue;
                    for (int k = j + 1; k < N; k++) {
                        if (map[j][k] == 1 && map[i][k] == 1) {
                            count++;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", t, count);
        }
    }
}
