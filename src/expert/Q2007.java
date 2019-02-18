package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2007 {

    static String[] out;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out = new String[T];
        for (int t = 0; t < T; t++) {
            String originString = br.readLine();
            String find = originString.charAt(0) + "";

            for (int i = 1; i <=9 ; i++) {
                String a = originString.substring(0, i);
                if (a.equals(originString.substring(a.length(), a.length() + i))) {
                    find = a;
                    break;
                }
            }
            out[t] = String.format("#%d %d", t + 1, find.length());
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


}
