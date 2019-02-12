package ex;

import java.util.Scanner;

public class Q5213 {
    static String out[];
    static long cache[] = new long[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int i = 1; i <= 1000000; i++) {
            findSum(i);
        }
        for (int t = 1; t <= T; t++) {
            long totalSum;
            int L = sc.nextInt();
            int R = sc.nextInt();
            totalSum = cache[R] - cache[L - 1];
            out[t - 1] = String.format("#%d %d", t, totalSum);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static void findSum(int n) {
        long sum = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                if (i % 2 == 1)
                    sum += i;
                if ((n / i) % 2 == 1)
                    sum += (n / i);
            }
        }
        int m = (int) Math.sqrt(n);
        if (m * m == n && m % 2 == 1) {
            sum -= m;
        }
        cache[n] = sum + cache[n - 1];
    }


}
