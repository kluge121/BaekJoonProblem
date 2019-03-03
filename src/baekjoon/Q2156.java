package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {
    static int N;
    static int[] map;
    static int[][] cache;
    static boolean visit[][];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cache = new int[N][3];
        visit = new boolean[N][3];

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        search(0, 0);
        System.out.println(max);

    }

    static int search(int index, int count) {
        if (index >= N) return 0;

        if (visit[index][count]) return cache[index][count];

        visit[index][count] = true;

        int value = 0;
        if (count < 2) {
            value = Math.max(search(index + 1, count + 1) + map[index], search(index + 1, 0));
        } else if (count == 2) {
            value = Math.max(search(index + 1, 0), value);
        }
        max = Math.max(max, value);
        return cache[index][count] = value;
    }
}
