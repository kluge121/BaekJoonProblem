package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2749 {


    static long[][] unit = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        boolean isOdd = false;

        if (n <= 1) {
            System.out.println(n);
            return;
        }
        else{
            long [][] gogo = search(n);
            System.out.println(gogo[0][1] % 1000000);
        }


    }

    static long[][] matrixTime(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += (a[i][k] * b[k][j]) % 1000000;
                }
            }
        }
        return result;
    }

    static long[][] search(long n) {
        if (n <= 1) return unit;
        long[][] tmp = search(n / 2);
        long[][] out = matrixTime(tmp, tmp);
        if(n % 2 ==1)
            out = matrixTime(out, unit);

        return out;

    }
}
