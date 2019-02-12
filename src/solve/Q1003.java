package solve;

import java.util.Scanner;

public class Q1003 {

    static int cache[];
    static int one_cache[];
    static int zero_cache[];
    static String[] arr;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        arr = new String[T];
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();

            cache = new int[N + 1];
            one_cache = new int[N + 1];
            zero_cache = new int[N + 1];
            if (N == 1) {
                arr[t - 1] = "0 1";
                continue;
            } else if (N == 0) {
                arr[t - 1] = "1 0";
                continue;
            }
            fibonacci(N);
            arr[t - 1] = zero_cache[N] + " " + one_cache[N];
        }

        for (String a : arr) {
            System.out.println(a);
        }
    }

    static int fibonacci(int n) {
        if (n > 1 && cache[n] != 0) {
            return cache[n];
        }
        if (n == 0) {
            zero_cache[0] = 1;
            return 0;
        } else if (n == 1) {
            one_cache[1] = 1;
            return 1;
        } else {
            cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
            zero_cache[n] = zero_cache[n - 1] + zero_cache[n - 2];
            one_cache[n] = one_cache[n - 1] + one_cache[n - 2];
            return cache[n];
        }


    }
}
