package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q4408 {
    static int[] count;
    static String[] out;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        out = new String[T];
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            count = new int[201];
            for (int i = 0; i < N; i++) {
                String[] a = br.readLine().split(" ");
                int n1 = Integer.parseInt(a[0]);
                int n2 = Integer.parseInt(a[1]);
                if (n1 % 2 == 0) {
                    n1 = n1 / 2;
                } else {
                    n1 = n1 / 2 + 1;
                }
                if (n2 % 2 == 0) {
                    n2 = n2 / 2;
                } else {
                    n2 = n2 / 2 + 1;
                }
                if (n2 < n1) {
                    for (int j = n2; j <= n1; j++) {
                        count[j]++;
                    }
                } else {
                    for (int j = n1; j <= n2; j++) {
                        count[j]++;
                    }
                }
            }
            Arrays.sort(count);
            out[t] = String.format("#%d %d", t + 1, count[200]);

        }
        for (String a : out) {
            System.out.println(a);
        }


    }


}
