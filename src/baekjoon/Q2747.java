package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2747 {

    static long[] cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cache = new long[92];
        int N = Integer.parseInt(br.readLine()) + 1;
        cache[1] = 0;
        cache[2] = 1;
        cache[3] = 1;
        if (N <= 3) System.out.println(cache[N]);
        else {
            go(N);
            System.out.println(cache[N]);
        }
    }

    static void go(int n) {
        if (cache[n - 2] == 0) go(n - 2);
        if (cache[n - 1] == 0) go(n - 1);

        cache[n] = cache[n - 2] + cache[n - 1];

    }

}
