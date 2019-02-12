package expert;

import java.util.Scanner;

public class Q6692 {
    static String out[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            double sum = 0.0;
            for (int i = 0; i < N; i++) {
                double tmp = sc.nextDouble() * (double) sc.nextInt();
                sum += tmp;
            }
            out[t - 1] =String.format("#%d %.6f",t,sum);
        }
        for (String a : out) {
            System.out.println(a);
        }

    }
}
