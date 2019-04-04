package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q3812 {


    static int X, Y, Z, A, B, C, N;
    static long[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {

            String[] a = br.readLine().split(" ");

            X = Integer.parseInt(a[0]);
            Y = Integer.parseInt(a[1]);
            Z = Integer.parseInt(a[2]);
            A = Integer.parseInt(a[3]);
            B = Integer.parseInt(a[4]);
            C = Integer.parseInt(a[5]);
            N = Integer.parseInt(a[6]);
            count = new long[N];


            ArrayList<Integer> xList1 = new ArrayList<>();
            ArrayList<Integer> xList2 = new ArrayList<>();

            ArrayList<Integer> yList1 = new ArrayList<>();
            ArrayList<Integer> yList2 = new ArrayList<>();

            ArrayList<Integer> zList1 = new ArrayList<>();
            ArrayList<Integer> zList2 = new ArrayList<>();


            if (A <= N) {
                for (int i = 0; i < A; i++) {
                    xList1.add((Math.abs(i - A)) % N);
                }
                for (int i = 0; i < N; i++) {
                    xList2.add(i);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    xList1.add((Math.abs(i - A)) % N);
                }
            }
            if (B <= N) {
                for (int i = 0; i < B; i++) {
                    yList1.add((Math.abs(i - B)) % N);
                }
                for (int i = 0; i < N; i++) {
                    yList2.add(i);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    yList1.add((Math.abs(i - B)) % N);
                }
            }
            if (C <= N) {
                for (int i = 0; i < C; i++) {
                    zList1.add((Math.abs(i - C)) % N);
                }
                for (int i = 0; i < N; i++) {
                    zList2.add(i);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    zList1.add((Math.abs(i - C)) % N);
                }
            }


            int xCycle = (xList2.size() - xList1.size()) / N;
            int yCycle = (yList2.size() - yList1.size()) / N;
            int zCycle = (zList2.size() - zList1.size()) / N;


            for (int i = 0; i < N; i++) {
                count[i] += xCycle * yCycle * zCycle;
            }

            int xd = (xList2.size() - xList1.size()) % N;
            int yd = (yList2.size() - yList1.size()) % N;
            int zd = (zList2.size() - zList1.size()) % N;


            for (int i = 0; i < xd; i++) {
                for (int j = 0; j < yd; j++) {
                    for (int k = 0; k < zd; k++) {
                        int index = (Math.abs(i - A) + Math.abs(j - B) + Math.abs(k - C)) % N;
                        count[index]++;
                    }
                }
            }


            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t + 1).append(" ");
            for (long value : count) {
                sb.append(value).append(" ");
            }
            out[t] = sb.toString();
        }

        for (String a : out) {
            System.out.println(a);
        }

    }
}
