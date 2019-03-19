package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q3074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> time;
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int M = Integer.parseInt(a[1]);
            time = new ArrayList<>();
            long max = 0;

            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(br.readLine());
                max = Math.max(value, max);
                time.add(value);
            }
            long left = M;
            long right = max * M;
            while (left < right) {
                long mid = (left + right) / 2;
                long cnt = 0;
                for (int i = 0; i < N; i++) cnt = cnt + (mid / time.get(i));
                if (cnt >= M) right = mid;
                else left = mid + 1;
            }
            out[t] = String.format("#%d %d", t + 1, left);
        }
        for (String a : out) System.out.println(a);
    }
}
