package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q1808 {

    static int[] state;
    static int goal;
    static int min;
    static int cache[];
    static String check = "";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");
            state = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                state[i] = Integer.parseInt(a[i]);
            }
            goal = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            cache = new int[(int) (goal + 1)];
            Arrays.fill(cache, -1);
            if (isNumberPossible(goal)) {
                out[t] = String.format("#%d %d", t + 1, String.valueOf(goal).length() + 1);
                continue;
            }


            int aa = search((int) goal);
            if (aa != -1) aa++;
            out[t] = String.format("#%d %d", t + 1, aa);

        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static int search(int value) {

        if (cache[value] > -1)
            return cache[value];

        if (String.valueOf(value).length() == 1) {
            if (!isNumberPossible(value)) {
                return -1;
            }
        }


        int min = Integer.MAX_VALUE;

        if (isNumberPossible(value)) {
            return cache[value] = String.valueOf(value).length();

        } else {
            for (int i : getYac(value)) {

                int tmp1 = search(value / i);
                if (tmp1 == -1) {
                    continue;

                }

                int tmp2 = search(i);
                if (tmp2 == -1)
                    continue;


                min = Math.min(min, tmp1 + tmp2 + 1);
            }

        }


        if (min == Integer.MAX_VALUE) {
            min = -1;
        }

        return cache[value] = min;

    }

    static ArrayList<Integer> getYac(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0 && i != 1 && i != n) {
                set.add(i);
                set.add((n / (n / i)));
            }

        }
        ArrayList<Integer> tmp = new ArrayList<Integer>(set);

        return tmp;

    }

    static boolean isNumberPossible(long n) {

        String checkStr = String.valueOf(n);

        for (int j = 0; j < checkStr.length(); j++) {
            int tmp = checkStr.charAt(j) - '0';
            if (state[tmp] == 0) {
                return false;
            }
        }

        return true;

    }
}
