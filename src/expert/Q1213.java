package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {

    static String[] out = new String[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 0; t < 10; t++) {
            br.readLine();
            String pattern = br.readLine();
            String origin = br.readLine();
            int count = 0;
            for (int i = 0; i <= origin.length() - pattern.length();) {
                String tmp = origin.substring(i, i+pattern.length());
                if (pattern.equals(tmp)) {
                    count++;
                    i = i + pattern.length();
                }else{
                    i++;
                }
            }
            out[t] = String.format("#%d %d",t+1,count);

        }


        for (String a : out) {
            System.out.println(a);
        }
    }


}
