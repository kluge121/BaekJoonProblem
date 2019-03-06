package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7206 {

    static int cache[];

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        cache = new int[100000];
        Arrays.fill(cache, -1);
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int result = search(input);
            out[t] = String.format("#%d %d", t + 1, result);
        }
        for (String a : out)
            System.out.println(a);
    }
    static int search(String str) {
        if (str.length() == 0)
            return 0;
        if (cache[Integer.parseInt(str)] != -1)
            return cache[Integer.parseInt(str)];
        int max = 0;
        for (int check = 1; check < Math.pow(2, str.length() - 1); check++) {
            int value = 1;
            int lastCut = 0;
            for (int i = 0; i < str.length() - 1; i++) {
                if ((check & 1 << i) >= 1) {
                    value *= Integer.parseInt(str.substring(lastCut, i + 1));
                    lastCut = i + 1;
                }
            }
            if (lastCut < str.length())
                value *= Integer.parseInt(str.substring(lastCut));
            max = Math.max(max, search(String.valueOf(value)) + 1);
        }
        return cache[Integer.parseInt(str)] = max;
    }
}
