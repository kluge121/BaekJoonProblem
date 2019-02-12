package expert;

import java.util.Scanner;

public class Q5789 {

    static int[] map;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            int Q = sc.nextInt();
            map = new int[N];

            for (int i = 1; i <= Q; i++) {
                int L = sc.nextInt();
                int R = sc.nextInt();
                for (int j = L - 1; j <= R - 1; j++) {
                    map[j] = i;
                }
            }
            String a = String.format("#%d ", t);
            for (int i = 0; i < N; i++) {
                a = a + map[i] + " ";
            }
            out[t - 1] = a;
        }
        for (String a : out)
            System.out.println(a);
    }
}
