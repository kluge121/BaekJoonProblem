package solve;

import java.util.Scanner;

public class Q2455 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int current = 0;
        for (int i = 0; i < 4; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
             current = current - out + in;
            max = Math.max(max,current);
        }
        System.out.println(max);
    }
}
