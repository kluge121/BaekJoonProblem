package ex;

import java.util.Scanner;

public class Q5431 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] list = new String[T];

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int ok = sc.nextInt();
            int countArray[] = new int[n + 1];

            for (int i = 1; i <= ok; i++) {
                int tmp = sc.nextInt();
                countArray[tmp] = 1;
            }
            String a = "";
            a = a + "#" + t + " ";
            for (int i = 1; i <= n; i++) {
                if (countArray[i] == 0)
                    a = a + i + " ";
            }
            list[t-1] = a;
        }
        for(String a : list){
            System.out.println(a);
        }
    }
}
