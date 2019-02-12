package expert;

import java.util.Arrays;
import java.util.Scanner;

public class Q5948 {

    static int[] array;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            int sum = 0;
            array = new int[7];
            for (int i = 0; i < 7; i++)
                array[i] = sc.nextInt();
            Arrays.sort(array);
            sum = array[6] + array[4] + array[3];
            out[t - 1] = String.format("#%d %d", t, sum);
        }
        for(String a : out){
            System.out.println(a);
        }

    }
}
