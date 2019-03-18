package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];
        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            String keyword = a[0];
            String buffer = a[1];
            int count = keyword.length();
            int index = 0;
            while (true) {
                index = keyword.indexOf(buffer, index);
                if (index == -1) break;
                index += buffer.length();
                count = count - buffer.length() + 1;
            }
            out[t] = String.format("#%d %d", t + 1, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}
