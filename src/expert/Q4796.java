package expert;

import java.util.Scanner;

public class Q4796 {

    static String[] out;
    static int[] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            map = new int[n];
            for (int i = 0; i < n; i++) {
                map[i] = sc.nextInt();
            }
            int count = 0;

            for (int i = 1; i < n - 1; i++) {
                int leftCount = 0;
                int rightCount = 0;
                if (map[i] > map[i - 1] && map[i] > map[i + 1]) {
                    for (int j = i - 2; j >= 0; j--) {
                        if (map[j] < map[j + 1])
                            leftCount++;
                        else
                            break;
                    }
                    for (int j = i + 2; j < map.length; j++) {
                        if (map[j] < map[j - 1])
                            rightCount++;
                        else
                            break;
                    }

                    count += ((leftCount + 1) * (rightCount + 1));
                }
            }
            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
