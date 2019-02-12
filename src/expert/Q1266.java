package expert;

import java.util.Scanner;

public class Q1266 {


    static int[] facArray = new int[19];
    static int[] prime = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        facArray[1] = 1;
        int T = sc.nextInt();
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            double aP = 0.0;
            double bP = 0.0;
            for (int p : prime) {
                aP += getProbability(p, a);
                bP += getProbability(p, b);
            }
            double result = aP + bP - (aP * bP);
            out[t] = String.format("#%d %.6f", t + 1, result);
        }
        for (String a : out) {
            System.out.println(a);
        }

    }

    static double getProbability(int count, int p) {
        double result = 1.0;
        result = result * combination(18, count) * Math.pow((p * 0.01), count) * Math.pow((1 - (p * 0.01)), 18 - count);
        return result;

    }
    static int combination(int n, int r) {
        int down1 = n - r;
        int down2 = r;
        int result = 1;
        if (down1 > down2) {
            int count = n - down1;
            int tmpN = n;
            for (int i = 0; i < count; i++) {
                result = result * tmpN--;
            }
            result = result / fac(down2);
        } else {
            int count = n - down2;
            int tmpN = n;
            for (int i = 0; i < count; i++) {
                result = result * tmpN--;
            }
            result = result / fac(down1);
        }
        return result;

    }
    static int fac(int n) {
        if (facArray[n] != 0)
            return facArray[n];
        if (n == 1 || n == 0) return 1;

        return n * fac(n - 1);

    }


}
