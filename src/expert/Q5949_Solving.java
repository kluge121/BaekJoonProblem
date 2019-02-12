package expert;

import java.util.Scanner;

public class Q5949_Solving {

    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {

            long count = 0;
            char[] bef = sc.next().toCharArray();
            char[] aft = sc.next().toCharArray();

            for (int i = 0; i < bef.length; i++) {
                if (bef[i] != aft[i]) {
                    char tmp = aft[i];
                    for (int j = i + 1; j < bef.length; j++) {
                        if (tmp == bef[j]) {
                            bef[j] = bef[i];
                            bef[i] = tmp;
                            count += j - i;
                            break;
                        }
                    }
                }
            }
            if (String.valueOf(bef).equals(String.valueOf(aft))) {
                out[t - 1] = String.format("#%d %d", t, count);
            } else {
                out[t - 1] = String.format("#%d %d", t, -1);
            }
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
