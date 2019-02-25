package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {

    static int[] zcount;
    static int[] ocount;
    static int[] pibo;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        zcount = new int[41];
        ocount = new int[41];
        zcount[1] = 0;
        ocount[1] = 1;

        ocount[0] = 0;
        zcount[0] = 1;

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            System.out.println(zcount[n]+" "+ocount[n]);
        }
    }

    static void fibo(int n) {
        if (ocount[n] != 0) return;
        for (int i = 2; i <= n; i++) {
            if (ocount[i] != 0) continue;
            ocount[i] = ocount[i - 1] + ocount[i - 2];
            zcount[i] = zcount[i - 1] + zcount[i - 2];
        }
    }
}

