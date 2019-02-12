package expert;

import java.util.Scanner;

public class Q1244 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] out = new String[T];
        sc.nextLine();

        for (int t = 0; t < T; t++) {
            String info = sc.next();
            int count = sc.nextInt();
            sc.nextLine();
            char[] map = info.toCharArray();

            int position = 0;
            int index = 0;

            for (int i = count; i > 0; i--) {
                if (position == map.length ) break;
                char max = 0;
                for (int j = position; j < map.length; j++) {
                    if (map[j] >= max) {
                        max = map[j];
                        index = j;
                    }
                }
                char tmp = map[position];
                map[position] = max;
                map[index] = tmp;
                position++;
            }
            out[t] = String.format("#%d %s", t + 1, String.valueOf(map));

        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
