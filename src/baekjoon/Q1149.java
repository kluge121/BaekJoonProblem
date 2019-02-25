package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {

    static int[] red;
    static int[] green;
    static int[] blue;
    static int[][] cache;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N][4];
        red = new int[N];
        green = new int[N];
        blue = new int[N];

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            red[i] = Integer.parseInt(a[0]);
            green[i] = Integer.parseInt(a[1]);
            blue[i] = Integer.parseInt(a[2]);
        }
        int redStart = search(0, 1);
        int greenStart = search(0, 2);
        int blueStart = search(0, 3);


        System.out.println(Math.min(redStart, Math.min(greenStart, blueStart)));

    }

    static int search(int depth, int prev) {
        if (depth == N) {
            return 0;
        }
        if (cache[depth][prev] != 0) {
            return cache[depth][prev];
        }
        int currentValue = 0;
        int min = 0;
        int value1, value2;
        if (prev == 1) {
            currentValue = red[depth];
            value1 = search(depth + 1, 2) + currentValue;
            value2 = search(depth + 1, 3) + currentValue;
        } else if (prev == 2) {
            currentValue = green[depth];
            value1 = search(depth + 1, 1) + currentValue;
            value2 = search(depth + 1, 3) + currentValue;
        } else {
            currentValue = blue[depth];
            value1 = search(depth + 1, 1) + currentValue;
            value2 = search(depth + 1, 2) + currentValue;

        }
        min = Math.min(value1, value2);
        return cache[depth][prev] = min;

    }
}
