package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {
    static int n;
    static int[] map;
    static int[] cache;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        cache = new int[n];


        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        cache[0] = map[0];
        cache[1] = map[0] + map[1];
        cache[2] = Math.max(map[0] + map[2], map[1] + map[2]);

        for (int i = 3; i <= n - 1; i++) {
            search(i);
        }
        System.out.println(cache[n - 1]);
    }

    static void search(int index) {
        int value1 = map[index] + cache[index - 2];
        int value2 = map[index] + map[index - 1] + cache[index - 3];
        cache[index] = Math.max(value1, value2);


    }
}

