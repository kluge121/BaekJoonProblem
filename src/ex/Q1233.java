package ex;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1233 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] out = new String[10];

        for (int t = 1; t <= 10; t++) {
            int v = sc.nextInt();
            sc.nextLine();
            for (int i = 1; i <= v; i++) {
                String input = sc.nextLine();
                StringTokenizer st = new StringTokenizer(input, " ");
                int count = 1;
                char a = 0;

                while (st.hasMoreTokens()) {
                    if (count == 2) {
                        a = st.nextToken().charAt(0);
                    } else {
                        st.nextToken();
                    }
                    count++;
                }

                if (count > 2) {
                    if (a >= 30 && a <= 39) {
                        out[t - 1] = String.format("#%d %d", t, 0);
                    }
                } else if (count == 2) {
                    if (a == 42 || a == 43 || a == 45 || a == 47) {
                        out[t - 1] = String.format("#%d %d", t, 0);
                    }
                }

            }
            if (out[t - 1] == null)
                out[t - 1] = String.format("#%d %d", t, 1);
        }

        for (String a : out) {
            System.out.println(a);
        }
    }
}
