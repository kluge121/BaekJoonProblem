package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Q1208 {

    static int[] map;
    static int[] outputList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        outputList = new int[10];
        for (int t = 1; t <= 10; t++) {
            int dump = sc.nextInt();
            map = new int[101];
            for (int i = 1; i <= 100; i++) {
                map[i] = sc.nextInt();
            }
            Arrays.sort(map);
            for (int i = 0; i < dump; i++) {
                map[100] = map[100] - 1;
                map[1] = map[1] + 1;
                Arrays.sort(map);
            }
            outputList[t - 1] = map[100] - map[1];
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("#%d %d\n", i + 1, outputList[i]);
        }

    }
}
