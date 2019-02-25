package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1912 {

    static int[] array;
    static int max = Integer.MIN_VALUE;
    static int sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N];
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(a[i]);
        }
        for (int i = N - 1; i > -1; i--) {
            if (array[i] <= array[i] + sum) {
                sum = array[i] + sum;
            } else if (array[i] > array[i] + sum) {
                sum = array[i];
            }
            max = Math.max(sum,max);
        }
        System.out.println(max);
    }
}
