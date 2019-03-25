import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HW0325 {
    static int[] cost;
    static int[] month = {0, 1, 3, 12};
    static int[] days;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] out = new String[T];

        for (int t = 0; t < T; t++) {
            min = Integer.MAX_VALUE;
            String[] a = br.readLine().split(" ");
            cost = new int[4];
            days = new int[13];
            for (int i = 0; i < 4; i++)
                cost[i] = Integer.parseInt(a[i]);

            String[] b = br.readLine().split(" ");
            for (int i = 1; i <= 12; i++) {
                days[i] = Integer.parseInt(b[i - 1]);
            }
            dfs(1, 0, 0);
            out[t] = String.format("#%d %d", t + 1, min);
        }
        for (String a : out) System.out.println(a);
    }
    static void dfs(int n, int sum, int count) {
        if (min < sum) return;
        if (n > 12) {
            min = Math.min(sum, min);
            return;
        }
        if (count == 0) {
            if (days[n] > 0) {
                for (int i = 0; i < 4; i++) {
                    if (i == 0) dfs(n + 1, (days[n] * cost[i]) + sum, 0);
                    else dfs(n + 1, cost[i] + sum, month[i] - 1);
                }
            } else dfs(n + 1, sum, 0);

        } else dfs(n + 1, sum, count - 1);
    }
}

