package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2156_solve {
    static int N;
    static int[] map;
    static int[] cache;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        cache = new int[N];
        visit = new boolean[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(search(i, 1), max);
        }
        System.out.println(max);
        System.out.println(Arrays.toString(cache));

    }

    static int search(int index, int count) {
        if (index >= N) return 0;
        if (visit[index]) return cache[index];
        visit[index] = true;
        int value1 = 0;

        if (count < 3 && index + 1 < N && !visit[index + 1]) {
            value1 = search(index + 1, count + 1) + map[index];
        }
        for (int i = index + 2; i < N; i++) {

            if (!visit[i])
                value1 = Math.max(search(i, 1) + map[index], value1);


        }
        return cache[index] = value1;
    }
}
