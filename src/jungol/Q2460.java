package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[4][4];


        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                int s = Integer.parseInt(a[j - 1]);
                score[j][s]++;
            }
        }

        int a = score[1][1] + score[1][2] * 2 + score[1][3] * 3;
        int b = score[2][1] + score[2][2] * 2 + score[2][3] * 3;
        int c = score[3][1] + score[3][2] * 2 + score[3][3] * 3;


        int max = Math.max(a, Math.max(b, c));


        if (a > b && a > c) {
            System.out.println("1 " + max);
        } else if (b > a && b > c) {
            System.out.println("2 " + max);
        } else if (c > b && c > a) {
            System.out.println("3 " + max);
        } else if (a == b && b == c) {
            if (score[1][3] > score[2][3] && score[1][3] > score[3][3])
                System.out.println("1 " + max);
            else if (score[2][3] > score[1][3] && score[2][3] > score[3][3])
                System.out.println("2 " + max);
            else if (score[3][3] > score[1][3] && score[3][3] > score[2][3])
                System.out.println("3 " + max);
            else{
                if (score[1][2] > score[2][2] && score[1][2] > score[3][2])
                    System.out.println("1 " + max);
                else if (score[2][2] > score[1][2] && score[2][2] > score[3][2])
                    System.out.println("2 " + max);
                else if (score[3][2] > score[1][2] && score[3][2] > score[2][2])
                    System.out.println("3 " + max);
                else {
                    System.out.println("0 " + max);
                }
            }

        } else {
            if (a > c && a == b) {
                if (score[1][3] > score[2][3]) {
                    System.out.println("1 " + max);
                } else if (score[1][3] < score[2][3]) {
                    System.out.println("2 " + max);
                } else {
                    if (score[1][2] > score[2][2]) {
                        System.out.println("1 " + max);
                    } else if (score[1][2] < score[2][2]) {
                        System.out.println("2 " + max);
                    } else {
                        System.out.println("0 " + max);
                    }
                }
            } else if (a > b && a == c) {
                if (score[1][3] > score[3][3]) {
                    System.out.println("1 " + max);
                } else if (score[1][3] < score[3][3]) {
                    System.out.println("3 " + max);
                } else {
                    if (score[1][2] > score[3][2]) {
                        System.out.println("1 " + max);
                    } else if (score[1][2] < score[3][2]) {
                        System.out.println("3 " + max);
                    } else {
                        System.out.println("0 " + max);
                    }
                }
            } else if (b > a && b == c) {
                if (score[2][3] > score[3][3]) {
                    System.out.println("2 " + max);
                } else if (score[2][3] < score[3][3]) {
                    System.out.println("3 " + max);
                } else {
                    if (score[2][2] > score[3][2]) {
                        System.out.println("2 " + max);
                    } else if (score[2][2] < score[3][2]) {
                        System.out.println("3 " + max);
                    } else {
                        System.out.println("0 " + max);
                    }
                }
            }


        }

    }
}
