package baekjoon;

import java.util.Scanner;

public class Q1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();
        int count = 0;

        while (goal > 0) {
            if ((goal % 2) == 1) {
                count++;
            }
            goal = goal / 2;
        }
        System.out.println(count);
    }
}
