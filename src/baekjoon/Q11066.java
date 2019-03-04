package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11066 {
    static int N;
    static int map[];
    static boolean visit[];
    static int cache[][];
    static int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 1];
            visit = new boolean[N + 1];
            cache = new int[N + 1][N + 1];
            sum = new int[N + 1];

            String[] a = br.readLine().split(" ");

            for (int i = 1; i <= a.length; i++) {
                int value = Integer.parseInt(a[i-1]);
                sum[i] = value + sum[i - 1] + map[i];
                map[i] = value;
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; i + j <= N; j++) {
                    int k = i + j;
                    cache[j][k] = Integer.MAX_VALUE;
                    for (int z = j; z < k; z++) {
                        cache[j][k] = Math.min(cache[j][k], cache[j][z] + cache[z + 1][k] + sum[k] - sum[j - 1]);
                    }
                }
            }
            out[t] = cache[1][N] + "";
        }
        for (String a : out) {
            System.out.println(a);
        }

    }


}
