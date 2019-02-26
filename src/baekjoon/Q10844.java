package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {

    static int cache[][];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cache = new int[10][N + 1];


        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            dfs(i, 1);
        }
        for (int i = 1; i <= 9; i++) {
            sum += cache[i][1];
            sum = sum % 1000000000;
        }
        sum = sum % 1000000000;
        System.out.println(sum);
    }

    static int dfs(int value, int d) {

        if (d == N) {
            cache[value][d] = 1;
            return 1;
        }
        if (cache[value][d] != 0)
            return cache[value][d];

        int count = 0;

        if (value - 1 >= 0)
            count += dfs(value - 1, d + 1);
        count = count % 1000000000;
        if (value + 1 <= 9)
            count += dfs(value + 1, d + 1);
        count = count % 1000000000;

        return cache[value][d] = count;
    }
}
