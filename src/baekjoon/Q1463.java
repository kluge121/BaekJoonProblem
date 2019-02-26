package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    static int n;
    static int cache[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cache = new int[n + 1];
        visit = new boolean[n + 1];

        search(n, 0);
        System.out.println(cache[n]);
    }

    static int search(int n, int count) {
        if (n == 1) return count;
        if (visit[n]) return cache[n];
        visit[n] = true;
        int min = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            min = Math.min(search(n / 3, count) + 1, min);
        }
        if (n % 2 == 0) {
            min = Math.min(search(n / 2, count) + 1, min);

        }
        min = Math.min(search(n - 1, count) + 1, min);

        return cache[n] = min;

    }


}


