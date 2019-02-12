package ex;

import java.util.Scanner;

public class Q4672 {

    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            char[] charArray = sc.next().toCharArray();
            int count = charArray.length;
            for (int i = 2; i <= charArray.length; i++) {
                for (int j = 0; j <= charArray.length - i; j++) {
                    int tmp = 0;
                    for (int k = 1; k <= i / 2; k++) {
                        if (!(charArray[j + (tmp)] == charArray[(j + i - 1) - tmp])) break;
                        if (k == i / 2) count++;
                    }
                }
            }
            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
