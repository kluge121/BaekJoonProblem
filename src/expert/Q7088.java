package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7088 {

    static String[] out;
    static int[] sum1;
    static int[] sum2;
    static int[] sum3;

    static int[][] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out = new String[T];

        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int Q = Integer.parseInt(a[1]);

            sum1 = new int[N + 1];
            sum2 = new int[N + 1];
            sum3 = new int[N + 1];
            sum = new int[4][N + 1];

            for (int i = 1; i <= N; i++) {
                int type = Integer.parseInt(br.readLine());

                sum[1][i] = sum[1][i - 1];
                sum[2][i] = sum[2][i - 1];
                sum[3][i] = sum[3][i - 1];
                sum[type][i]++;
            }
            StringBuilder result = new StringBuilder(String.format("#%d\n", t + 1));

            for (int i = 0; i < Q; i++) {
                String[] b = br.readLine().split(" ");
                int start = Integer.parseInt(b[0]);
                int end = Integer.parseInt(b[1]);

                int j1 = sum[1][end] - sum[1][start - 1];
                int j2 = sum[2][end] - sum[2][start - 1];
                int j3 = sum[3][end] - sum[3][start - 1];
                result.append(j1).append(" ").append(j2).append(" ").append(j3).append("\n");
            }
            out[t] = result.toString();

        }

        for (String a : out) {
            System.out.print(a);
        }

    }
}
