package ex;

import java.util.Scanner;

public class Q6808 {

    static String[] out;
    static int map[];
    static int a[];
    static int b[];
    static int aTotal;
    static int bTotal;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        out = new String[T];
        for (int t = 1; t <= T; t++) {

            map = new int[19];
            a = new int[9];
            b = new int[9];
            aTotal = 0;
            bTotal = 0;
            int b_i = 0;

            for (int i = 0; i < 9; i++) {
                int input = sc.nextInt();
                map[input] = 1;
                a[i] = input;
            }
            for (int i = 1; i <= 18; i++) {
                if (map[i] != 1) {
                    b[b_i] = i;
                    b_i++;
                }
            }
            permutation(0);
            out[t - 1] = String.format("#%d %d %d", t, aTotal, bTotal);

        }

        for (String a : out) {
            System.out.println(a);
        }

    }

    static void permutation(int depth) {

        if (depth == 9) {
            int aSum = 0;
            int bSum = 0;
            for (int i = 0; i < 9; i++) {
                if (a[i] > b[i]) {
                    aSum +=  a[i] + b[i];
                } else {
                    bSum += a[i] + b[i];
                }
            }

            if (aSum > bSum) aTotal++;
            else if (aSum < bSum) bTotal++;
        }

        for (int i = depth; i < b.length; i++) {
            swap(i, depth);
            permutation(depth + 1);
            swap(i, depth);
        }
    }


    static void swap(int i, int j) {
        int tmp = b[i];
        b[i] = b[j];
        b[j] = tmp;
    }


}
