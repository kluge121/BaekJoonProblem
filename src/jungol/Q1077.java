package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1077 {

    static int N;
    static int W;
    static Jewel[] array;
    static int[][] cache;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        W = Integer.parseInt(a[1]);
        array = new Jewel[N];
        cache = new int[N+1][W+1];
        max = 0;
        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            int w = Integer.parseInt(b[0]);
            int v = Integer.parseInt(b[1]);
            array[i] = new Jewel(v, w);
        }
        int count = 1;
        for (int i = 0; i < N; i++) {
            Jewel tmp = array[i];
            for (int j = 1; j <= W; j++) {
                if (j - tmp.weight >= 0) {
                    cache[count][j] = Math.max(Math.max(cache[count - 1][j - tmp.weight] + tmp.value, cache[count][j - tmp.weight] + tmp.value), cache[count][j]);
                    max = Math.max(cache[count][j], max);
                } else {
                    cache[count][j] = cache[count - 1][j];
                }
            }
            count++;
        }
        System.out.println(max);
    }
    static class Jewel {
        int value, weight;

        public Jewel(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}