package ex;

import java.util.Scanner;

public class Q1204 {

    static int count[] = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            i = sc.nextInt();
            for (int j = 0; j <= 999; j++) {
                int input = sc.nextInt();
                count[input]++;
            }
            int maxValue = 0;
            for (int k = 0; k <= 100; k++) {
                if (count[k] >= count[maxValue]) {
                    maxValue = k;
                }
            }
            System.out.printf("#%d %d\n", i, maxValue);
        }
    }
}
