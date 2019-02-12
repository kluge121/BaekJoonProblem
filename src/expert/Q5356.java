package expert;

import java.util.Arrays;
import java.util.Scanner;

public class Q5356 {
    static char[][] map;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            map = new char[5][15];

            for (int i = 0; i <= 4; i++) {
                Arrays.fill(map[i], '?');
            }
            for (int i = 0; i <= 4; i++) {
                String input = sc.next();
                for (int j = 0; j < input.length(); j++) {
                    map[i][j] = input.charAt(j);
                }
            }
            String result = "";
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[j][i] != '?') {
                        result += map[j][i];
                    }
                }
            }
            out[t - 1] = "#" + t + " " + result;
        }
        for (String a : out) {
            System.out.println(a);
        }

    }
}
