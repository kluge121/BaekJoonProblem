package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1865 {

    static double[][] map;
    static double max;
    static int N;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            max = 0.0;
            map = new double[N][N];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Double.parseDouble(a[j]) / 100;
                }
            }
            search(1, 0);
            out[t] = String.format("#%d %.6f", t + 1, max * 100);
        }
        for (String a : out) {
            System.out.println(a);
        }

    }

    static void search(double mul, int d) {
        if (mul < max) return;
        if (d == N - 1) {
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    mul = mul * map[d][i];
                    max = Math.max(mul, max);
                }
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && mul * map[d][i] > max) {
                visit[i] = true;
                search(mul * map[d][i], d + 1);
                visit[i] = false;

            }
        }


    }
}
