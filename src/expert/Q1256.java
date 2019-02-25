package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1256 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            int lineNum = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] post = new String[input.length()];
            for (int i = 0; i <input.length(); i++) {
                post[i] = input.substring(i);
            }

            Arrays.sort(post);
            out[t] = String.format("#%d %s", t + 1, post[lineNum - 1]);

        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}