package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4261 {

    static int count;
    static int n;
    static String s;
    static int[] index = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {
            count = 0;
            String[] a = br.readLine().split(" ");
            s = a[0];
            n = Integer.parseInt(a[1]);
            String[] k = br.readLine().split(" ");
            for (String s1 : k) {
                if (s.length() == s1.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < s1.length(); i++) sb.append(index[s1.charAt(i) - 97]);
                    if (sb.toString().equals(s)) count++;
                }
            }
            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) System.out.println(a);

    }
}
