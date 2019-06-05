package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2839 {

    static int N;
    static int[] cache;
    static int INF = 9999999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N + 1];



        if (N % 5 == 0) {
            System.out.println(N / 5);
            return;
        }
        Arrays.fill(cache, INF);

        cache[3] = 1;

        if (N >= 5) {
            cache[5] = 1;
            for (int i = 6; i <= N; i++) {

                if (cache[i - 3] == INF && cache[i - 5] == INF) {
                    continue;
                }
                if (cache[i - 3] != INF) {
                    cache[i] = cache[i - 3] + 1;
                }
                if (cache[i - 5] != INF) {
                    cache[i] = Math.min(cache[i], cache[i - 5] + 1);
                }
            }
        }

        if (cache[N] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(cache[N]);
        }

    }


}
