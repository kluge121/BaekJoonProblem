package ex;

import java.util.Scanner;

public class Q5688 {
    static String out[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            long n = sc.nextLong();
            if (n == 1) {
                out[t - 1] = String.format("#%d %d", t, 1);
                continue;
            }
            long tmp = Math.round(Math.pow(n, 1.0 / 3.0));
            if (tmp * tmp * tmp == n) {
                out[t - 1] = String.format("#%d %d", t, tmp);
            } else {
                out[t - 1] = String.format("#%d %d", t, -1);
            }
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
