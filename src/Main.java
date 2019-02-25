import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] coin;
    static int[] count;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        n = Integer.parseInt(a[0]);
        k = Integer.parseInt(a[1]);

        coin = new int[n];
        count = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            count[coin[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int value : coin) {
                if (i - value >= 0) {
                    count[i]++;
                }
            }
        }
        count[0] = 1;
        for(int i = 1; i<=k; i++){
            search(i);
        }
        System.out.println(count[k]);
        System.out.println(Arrays.toString(count));
    }

    static void search(int value) {
        for (int i : coin) {
            if (value - i >= 0) {
                count[value] += count[value-i];
            }


        }


    }

}
