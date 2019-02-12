package baekjoon;

import java.util.Scanner;

public class Q10253 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = 2;
            while (a != 1) {
                if ((double) a / (double) b > 1 / (double) c) {
                    a = a * c - b;
                    b = b * c;
                    int v = gcd(a, b);
                    a = a / v;
                    b = b / v;
                } else if (((double) a / (double) b) < (1 / (double) c)) {
                    c = (b / a) + 1;
                }
            }
            System.out.println(b);
        }
    }
    static int gcd(int x, int y) {
        while (true) {
            if (x > y) {
                x = x % y;
                if (x == 0) return y;
            } else if (x < y) {
                y = y % x;
                if (y == 0) return x;
            }
        }
    }
}
