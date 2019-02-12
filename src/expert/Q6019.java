package expert;

import java.util.Scanner;

public class Q6019 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int distance = sc.nextInt();
            double ab = (double) ( sc.nextInt() +  sc.nextInt());
            int f = sc.nextInt();
            double distanceUnit = distance / ab;
            double time = distanceUnit * f;
            System.out.printf("#%d %f", t, time);
        }
    }
}
