package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2293 {

    static int[] coin;
    static int[] count;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        k = Integer.parseInt(a[1]);

        coin = new int[n];
        count = new int[k + 1];
        count[0] = 1;

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int value : coin) {
            for (int i = value; i <= k; i++) {
                count[i] += count[i - value];
            }
        }
        System.out.println(count[k]);
    }

}
