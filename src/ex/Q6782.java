package ex;

import java.util.Scanner;

public class Q6782 {

    static String[] out;
    static int[] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            long count = 0;
            long target = 0;
            long n = sc.nextLong();
            if (n == 2) {
                out[t - 1] = String.format("#%d %d", t, 0);
            }

            while (n != 2) {

                target = (int) Math.sqrt(n);
                if (target * target == n) {
                    count++;
                    n = target;
                } else {
                    target = (long) Math.sqrt(n) + 1;
                    count += (target * target) - n;
                    n = target;
                    count++;
                }

            }
            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
