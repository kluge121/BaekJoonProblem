package expert;

import java.util.Scanner;

public class Q1225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] out = new String[10];
        for (int t = 0; t < 10; t++) {
            int[] array = new int[8];
            sc.nextInt();
            for (int i = 0; i < 8; i++) {
                array[i] = sc.nextInt();
            }
            int count = 1;
            while (true) {
                int tmp = array[0] - count;
                count++;
                if (count == 6) {
                    count = 1;
                }
                System.arraycopy(array, 1, array, 0, 7);
                if (tmp <= 0) {
                    array[7] = 0;
                    break;
                } else {
                    array[7] = tmp;
                }
            }
            out[t] = String.format("#%d %d %d %d %d %d %d %d %d", t + 1, array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
