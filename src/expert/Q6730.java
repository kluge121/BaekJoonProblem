package expert;

import java.util.Scanner;

public class Q6730 {


    static int[] map;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            int up = 0;
            int down = 0;
            int n = sc.nextInt();
            map = new int[n];
            for (int i = 0; i < n; i++) {
                map[i] = sc.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                if (map[i] > map[i + 1]) {
                    down = Math.max(map[i] - map[i + 1], down);
                } else {
                    up = Math.max(map[i + 1] - map[i], up);
                }
            }
            out[t - 1] = "#" + t + " " + up + " " + down;
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
