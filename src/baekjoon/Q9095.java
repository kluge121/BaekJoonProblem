package baekjoon;

import java.util.Scanner;

public class Q9095 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int[] answer = new int[testCaseCount];
        for (int i = 0; i < testCaseCount; i++) {
            int goalNumber = sc.nextInt();
            int[] cache = new int[11];
            cache[1] = 1;
            cache[2] = 2;
            cache[3] = 4;
            if (goalNumber <= 3) {
                answer[i] = cache[goalNumber];
            } else {
                for (int j = 4; j <= goalNumber; j++)
                    cache[j] = cache[j - 1] + cache[j - 2] + cache[j - 3];
                answer[i] = cache[goalNumber];
            }
        }
        for (int anAnswer : answer) System.out.println(anAnswer);
    }
}
