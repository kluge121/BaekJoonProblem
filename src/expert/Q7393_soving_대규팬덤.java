package expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q7393_soving_대규팬덤 {

    static int cache[][];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];


        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            cache = new int[10][N + 1];

            for (int i = 0; i < 10; i++) {
                Arrays.fill(cache[i], -1);
            }

            int sum = 0;

            for (int i = 1; i <= 9; i++) {
                boolean[] visit = new boolean[10];
                visit[i] = true;
                dfs(i, 1, visit);
            }

            for (int i = 1; i <= 9; i++) {
                sum += cache[i][1];
                sum = sum % 1000000000;
            }


            sum = sum % 1000000000;
            out[t] = String.format("#%d %d", t + 1, sum);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static int dfs(int value, int d, boolean[] visit) {

        if (d == N) {

            boolean flag = true;
            for (int i = 0; i < 10; i++) {
                if (!visit[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return 1;
            } else {
                return 0;
            }
        }


        if (cache[value][d] != -1)

            return cache[value][d];

        int count = 0;

        if (value - 1 >= 0) {
            boolean[] copy = copyArray(visit);
            copy[value - 1] = true;
            count += dfs(value - 1, d + 1, copy);
            count = count % 1000000000;
        }

        if (value + 1 <= 9) {
            boolean[] copy = copyArray(visit);
            copy[value + 1] = true;
            count += dfs(value + 1, d + 1, copy);
            count = count % 1000000000;
        }


        return cache[value][d] = count;
    }


    static boolean[] copyArray(boolean[] visit) {

        boolean[] newArray = new boolean[10];
        System.arraycopy(visit, 0, newArray, 0, 10);
        return newArray;
    }


}
