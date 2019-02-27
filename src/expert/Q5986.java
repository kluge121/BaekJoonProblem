package expert;

import java.util.ArrayList;
import java.util.Scanner;

public class Q5986 {

    static ArrayList<Integer> primeList;
    static int lastPrime;
    static String[] out;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        primeList = new ArrayList<>();
        primeList.add(2);
        lastPrime = 2;
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            int count = 0;
            int n = sc.nextInt();
            if (n > lastPrime) {
                for (int i = lastPrime + 1; i <= n; i++) {
                    if (isPrime(i)) {
                        primeList.add(i);
                        lastPrime = i;
                    }
                }
            }
            //같은 소수 3개로 만드는 경우
            if (n % 3 == 0 && isPrime(n / 3)) {
                count += 1;
            }

            //같은 소수 2개와 다른 1개의 소수
            for (int i : primeList) {
                int tmp = n - (i * 2);
                if (tmp > 1 && isPrime(tmp) && tmp != i) {
                    count += 1;
                }
            }
            //모두 다른 3개의 소수
            for (int i = 0; i < primeList.size() - 2; i++) {
                if (n < primeList.get(i)) break;
                for (int j = i + 1; j < primeList.size() - 1; j++) {
                    if (n < primeList.get(j)) break;
                    int tmp = n - (primeList.get(i) + primeList.get(j));
                    if (tmp > 1 && isPrime(tmp) && tmp != primeList.get(i) && tmp != primeList.get(j) && tmp > primeList.get(i) && tmp > primeList.get(j)) {
                        count += 1;
                    }
                }
            }

            out[t - 1] = String.format("#%d %d", t, count);
        }
        for (String a : out) {
            System.out.println(a);
        }
    }

    static boolean isPrime(int n) {
        boolean isS = true;

        for (int i : primeList) {
            if (i >= n) break;
            else {
                if (n % i == 0) {
                    isS = false;
                    break;
                }
            }
        }
        return isS;
    }
}
