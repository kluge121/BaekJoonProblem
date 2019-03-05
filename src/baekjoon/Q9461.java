package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {

    static long[] cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        cache = new long[101];
        cache[1] = 1;
        cache[2] = 1;
        cache[3] = 1;
        cache[4] = 2;
        cache[5] = 2;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            if (N <= 5 || cache[N] != 0) {
                out.append(cache[N]).append("\n");
                continue;
            }
            find(N);
            out.append(cache[N]).append("\n");
        }
        System.out.print(out);
    }


    static void find(int n) {

        if (cache[n - 5] == 0)
            find(n - 5);
        if (cache[n - 1] == 0)
            find(n - 1);

        cache[n] = cache[n - 1] + cache[n - 5];

    }

}
