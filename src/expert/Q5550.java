package expert;

import java.util.Scanner;

public class Q5550 {

    static String input;
    static int[] count;
    static String[] out;
    static int nowFrog;
    static int endFrog;
    static int maxFrog;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        out = new String[T];

        for (int t = 1; t <= T; t++) {
            input = sc.next();
            count = new int[5];

            nowFrog = 0;
            endFrog = 0;
            maxFrog = 0;

            // 5자리가 안되거나/ 1마리가 계속우는 경우 체크
            if (input.length() % 5 != 0) {
                out[t - 1] = String.format("#%d %d", t, -1);
                continue;
            }
            int index = 0;
            int counter = 0;
            for (int i = 0; i < input.length() / 5; i++) {
                if (input.substring(index, index + 5).equals("croak")) {
                    counter++;
                    index += 5;
                }
            }
            if (counter == input.length() / 5) {
                out[t - 1] = String.format("#%d %d", t, 1);
                continue;
            }

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'c') {
                    count[0]++;
                    if (endFrog < 1) {
                        nowFrog++;
                        maxFrog = Math.max(nowFrog, maxFrog);
                    } else {
                        nowFrog++;
                        endFrog--;
                    }
                } else if (input.charAt(i) == 'r') {
                    count[1]++;

                } else if (input.charAt(i) == 'o') {
                    count[2]++;
                } else if (input.charAt(i) == 'a') {
                    count[3]++;
                } else if (input.charAt(i) == 'k') {
                    count[4]++;
                    endFrog++;
                    nowFrog--;
                }
                if (!isSequenceValid())
                    out[t - 1] = String.format("#%d %d", t, -1);
            }
            if (out[t - 1] == null && isResultCountValid()) {
                out[t - 1] = String.format("#%d %d", t, maxFrog);
            } else if (out[t - 1] == null) {
                out[t - 1] = String.format("#%d %d", t, -1);
            }
        }
        for (String a : out) {
            System.out.println(a);
        }
    }


    static boolean isSequenceValid() {
        return count[0] >= count[1] && count[1] >= count[2] && count[2] >= count[3] && count[3] >= count[4];
    }

    static boolean isResultCountValid() {
        return count[0] == count[1] && count[1] == count[2] && count[2] == count[3] && count[3] == count[4];
    }

}
