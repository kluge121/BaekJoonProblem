package expert;

import java.util.Scanner;

public class Q6718 {


    static String[] outList;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        outList = new String[T];
        for (int t = 1; t <= T; t++) {
            double n = (double) sc.nextInt() / (double) 1000;
            if (n >= 1000.0) {
                outList[t - 1] = "#" + t + " 5";

            } else if (n >= 100.0) {
                outList[t - 1] = "#" + t + " 4";
            } else if (n >= 10) {
                outList[t - 1] = "#" + t + " 3";

            } else if (n >= 1) {
                outList[t - 1] = "#" + t + " 2";

            } else if (n >= 0.1) {
                outList[t - 1] = "#" + t + " 1";

            } else {
                outList[t - 1] = "#" + t + " 0";

            }
        }

        for (String a : outList) {
            System.out.println(a);
        }
    }
}
