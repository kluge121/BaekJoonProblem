package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Q6719 {

    static int map[];
    static String out[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {

            //N개중 K를 선택해서 본다.
            int N = sc.nextInt();
            int K = sc.nextInt();
            double a = 0.0;
            map = new int[N];
            for (int i = 0; i < N; i++) {
                map[i] = sc.nextInt();
            }
            Arrays.sort(map);
            for (int i = map.length - K; i <= map.length - 1; i++) {
                a = ((double) map[i] + a) / 2;
            }

            out[t - 1] = String.format("#%d %6f", t, a);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

}
