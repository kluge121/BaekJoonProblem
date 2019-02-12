package expert;

import java.util.Scanner;

public class Q2805 {


    static int[][] map;
    static int mapSize;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            mapSize = sc.nextInt();
            map = new int[mapSize][mapSize];

            int sum = 0;
            for (int i = 0; i < mapSize; i++) {
                String input = sc.next();
                for (int j = 0; j < mapSize; j++) {
                    map[i][j] = input.charAt(j) - '0';
                    sum += map[i][j];
                }
            }


            int index = mapSize / 2;

            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index - i; j++) {
                    sum = sum - map[i][j];
                    sum = sum - map[i][mapSize - 1 - j];

                    map[i][j] = -1;
                    map[i][mapSize - 1 - j] = -1;
                }
            }

            for (int i = index + 1; i < mapSize; i++) {
                for (int j = 0; j < i - index; j++) {
                    sum = sum - map[i][j];
                    sum = sum - map[i][mapSize - 1 - j];

                    map[i][j] = -1;
                    map[i][mapSize - 1 - j] = -1;
                }
            }

            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            out[t - 1] = String.format("#%d %d", t, sum);
        }

        for (String a : out) {
            System.out.println(a);
        }

    }
}
