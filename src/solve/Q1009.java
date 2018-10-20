package solve;

import java.util.Scanner;

public class Q1009 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int caseCount = sc.nextInt();
        int[][] caseList = new int[caseCount][2];

        for (int i = 0; i < caseCount; i++) {
            caseList[i][0] = sc.nextInt();
            caseList[i][1] = sc.nextInt();
        }
        for (int i = 0; i < caseCount; i++) {
            search(caseList[i][0], caseList[i][1]);
        }
    }

    static void search(int a, int b) {

        int result = 1;
        for (int i = 0; i < b; i++) {
            result = result * a;
            result = result % 10;
        }
        if (result == 0)
            System.out.println(10);
        else
            System.out.println(result);

    }

}
