package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Q1257 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            HashSet<String> hashSet = new HashSet<>();
            int order = Integer.parseInt(br.readLine());
            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j <= input.length(); j++) {
                    hashSet.add(input.substring(i, j));
                }
            }
            ArrayList<String> list = new ArrayList<>(hashSet);
            list.sort(String::compareTo);

            out[t] = String.format("#%d %s", t + 1, list.get(order-1));
        }
        for (String a : out) {
            System.out.println(a);
        }
    }
}