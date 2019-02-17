package expert;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q5215 {


    static int[] cal;
    static int[] point;
    static int max;
    static int limitCal;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            String[] a = br.readLine().split(" ");
            count = Integer.parseInt(a[0]);
            limitCal = Integer.parseInt(a[1]);
            max = 0;
            cal = new int[count];
            point = new int[count];

            for (int i = 0; i < count; i++) {
                String[] b = br.readLine().split(" ");
                int tPotin = Integer.parseInt(b[0]);
                int tCal = Integer.parseInt(b[1]);
                cal[i] = tCal;
                point[i] = tPotin;
            }

            search(0, 0, 0);

            out[t] = String.format("#%d %d", t + 1, max);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static void search(int depth, int nowCal, int nowPoint) {

        if (depth == count) {
            return;
        } else if (cal[depth] + nowCal <= limitCal) {
            max = Math.max(max, point[depth] + nowPoint);

        }
        search(depth + 1, nowCal, nowPoint);
        search(depth + 1, nowCal + cal[depth], nowPoint + point[depth]);


    }
}
