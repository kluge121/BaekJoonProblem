import java.util.Arrays;
import java.util.Scanner;

public class Q1463 {


    static int[] cache;

    final static int NONE = -1;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        cache = new int[N + 1];

        Arrays.fill(cache, -1);

        System.out.print(search(N));

    }

    static int search(int n) {

        if (n == 1)
            return 0;

        if (cache[n] != NONE)
            return cache[n];

        int value1 = 10000000;
        int value2 = 10000000;
        int value3 = 0;

        if (n % 3 == 0)
            value1 = search(n / 3)+1;

        if (n % 2 == 0)
            value2 = search(n / 2)+1;

        value3 = search(n - 1)+1;

        return cache[n] = Math.min(value1, Math.min(value2, value3));
    }

}
