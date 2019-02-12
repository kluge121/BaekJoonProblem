package ex;

import java.util.Scanner;

public class Q6485 {

    static int a[];
    static int b[];
    static int c[];
    static int count[];
    static String[] out;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //버스 노선
            a = new int[N];
            b = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
            }
            int p = 0;
            p = sc.nextInt();
            count = new int[p];
            c = new int[p];
            for (int i = 0; i < p; i++) {
                c[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                int aa = a[i];
                int bb = b[i];
                for (int j = 0; j < c.length; j++) {
                    if (c[j] >= aa && c[j] <= bb) {
                        count[j]++;
                    }
                }
            }
            String a = String.format("#%d ", t);
            for (int i = 0; i < count.length; i++) {
                a += count[i] + " ";
            }
            out[t - 1] = a;
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
