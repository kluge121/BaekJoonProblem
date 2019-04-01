package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14888 {

    static int[] op;
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        op = new int[4];
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(a[i]);
        String[] b = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(b[i]);


        search(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void search(int result, int d) {
        if (d == N) {
            max = Math.max(result, max);
            min = Math.min(result, min);
        }

        if (op[0] > 0) {
            op[0]--;
            search(result + num[d], d + 1);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            search(result - num[d], d + 1);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            search(result * num[d], d + 1);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            search(result / num[d], d + 1);
            op[3]++;
        }

    }
}
