package baekjoon;

import java.util.Scanner;

public class Q1057 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int i = sc.nextInt();
        int round = 0;

        while (true) {
            round++;
            if ((i - 1) / 2 + 1 == (k - 1) / 2 + 1) {
                System.out.println(round);
                break;
            } else {
                i = (i - 1) / 2 + 1;
                k = (k - 1) / 2 + 1;
            }
        }

    }
}
