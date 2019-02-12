package ex;

import java.util.Scanner;

public class Q5607_Ferma {

    static final int DIVISOR = 1234567891;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int R = sc.nextInt();
            long result = nCr(N, R, DIVISOR);
            out[t] = String.format("#%d %d",t+1,result);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
    static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }
    static long nCr(int n, int r, int p) {
        if (r == 0) {
            return 1L;
        }
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
    }
    public static long power(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

}
