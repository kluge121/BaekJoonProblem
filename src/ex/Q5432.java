package ex;

import java.util.Scanner;

public class Q5432 {
    static String input;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            input = sc.next();
            input += ",";
            int open = 0;
            int sum = 0;
            for (int i = 0; i < input.length() - 1; ) {
                if (input.charAt(i) == '(' && input.charAt(i + 1) != ')') {
                    open++;
                    i++;
                } else if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
                    sum += open;
                    i = i + 2;
                } else if (input.charAt(i) == ')') {
                    sum++;
                    open--;
                    i++;
                }
            }
            out[t - 1] = String.format("#%d %d", t, sum);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
