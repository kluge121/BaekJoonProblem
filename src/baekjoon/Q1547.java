package baekjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Q1547 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int[] map = {0, 1, 0, 0}; // 컵의 위치
        for (int i = 0; i < M; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int tmp = map[c1];
            map[c1] = map[c2];
            map[c2] = tmp;
        }
        for (int i = 1; i <= 3; i++) {
            if (map[i] == 1)
                System.out.println(i);
        }



    }
}
