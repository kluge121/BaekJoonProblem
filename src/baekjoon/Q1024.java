package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1024 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        for (int i = L; i <= 100; i++) {
            int presumeValue = N / i;
            int sum = presumeValue;
            ArrayList<Integer> list = new ArrayList<>();
            boolean flag = false;
            if (i % 2 == 0) {
                for (int j = 1; j <= i / 2; j++) {
                    list.add(presumeValue + j);
                    sum += presumeValue + j;
                }
                for (int j = 1; j <= i / 2 - 1; j++) {
                    if (presumeValue - j < 0) {
                        flag = true;
                        break;
                    }
                    list.add(presumeValue - j);
                    sum += presumeValue - j;
                }
            } else {
                for (int j = 1; j <= i / 2; j++) {
                    list.add(presumeValue + j);
                    sum += presumeValue + j;
                }
                for (int j = 1; j <= i / 2; j++) {
                    if (presumeValue - j < 0) {
                        flag = true;
                        break;
                    }
                    list.add(presumeValue - j);
                    sum += presumeValue - j;
                }
            }
            if (flag) continue;
            list.add(presumeValue);
            if (sum == N) {
                list.sort(Integer::compareTo);
                for(int k : list){
                    System.out.print(k+" ");
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
