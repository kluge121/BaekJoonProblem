package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Q6190 {

    static int[] arr;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            arr = new int[N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    String strNum = String.valueOf(arr[i] * arr[j]);
                    if (findHanjoGak(strNum)) {
                        max = Math.max(max, Integer.parseInt(strNum));
                    }
                }
            }
            if (max == 0) {
                out[t - 1] = String.format("#%d %d", t, -1);
            } else {
                out[t - 1] = String.format("#%d %d", t, max);
            }
        }
        for (String a : out)
            System.out.println(a);
    }

    static boolean findHanjoGak(String n) {
        int sameCount = 0;
        if (n.length() == 1) return false;
        for (int i = 0; i < n.length() - 1; i++) {
            if (n.charAt(i) - '0' > n.charAt(i + 1) - '0') {
                return false;
            } else if (n.charAt(i) - '0' == n.charAt(i + 1) - '0') {
                sameCount++;
            }
        }
        return sameCount != n.length();
    }
}
